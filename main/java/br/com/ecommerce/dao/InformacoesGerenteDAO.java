/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.dao;

import br.com.ecommerce.classes.InfoGerente;
import br.com.ecommerce.connectionBD.SingleConnection;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class InformacoesGerenteDAO {
    
    private Connection connection;

    public InformacoesGerenteDAO() {
        connection = SingleConnection.getConnection();
    }
    
    public double valorTotalProdutos(EstadoProduto estado) throws SQLException {
    
        connection = SingleConnection.getConnection();
        String sql = "select situacao,sum(preco) as total from produtos where situacao = ? group by situacao";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, estado.getType());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Double total = rs.getDouble("total");
                SingleConnection.close(rs, ps);
                return total;
            } else return 0;
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        
    }
    
    public int quantidadeTotalProdutos(EstadoProduto estado) throws SQLException {
    
        connection = SingleConnection.getConnection();
        String sql = "select situacao,count(situacao) as quantidade from produtos where situacao = ? group by situacao";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, estado.getType());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int quantidade = rs.getInt("quantidade");
                SingleConnection.close(rs, ps);
                return quantidade;
            } else return 0;
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        
    }
    
    public List<InfoGerente> valorPorProduto(EstadoProduto estado) throws SQLException {
    
        connection = SingleConnection.getConnection();
        String sql = "select nome,sum(preco) as total from produtos where situacao = ? group by nome";
        List<InfoGerente> list = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, estado.getType());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new InfoGerente(rs.getString("nome"), rs.getDouble("total")));
            }
            SingleConnection.close(rs, ps);
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        return list;
    }
    
}
