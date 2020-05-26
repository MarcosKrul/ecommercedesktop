/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.dao;

import br.com.ecommerce.classes.Produto;
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
public class FiltroDAO {
    
    private Connection connection;

    public FiltroDAO() {
        connection = SingleConnection.getConnection();
    }
    
    private List<Produto> daoBase (String sql) throws SQLException {
        
        List<Produto> lista = new ArrayList<>();
        Produto p = null;
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p = new Produto();
                p.setNome(rs.getString("nome"));
                p.setCategoria(rs.getString("categoria"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setId_produto(rs.getInt("id_produto"));
                p.setId_foreign(rs.getInt("id_foreign_produto"));
                switch(rs.getInt("situacao")){
                    case 1: p.setSituacao(EstadoProduto.ESTOQUE); break;
                    case 2: p.setSituacao(EstadoProduto.INDISPONIVEL); break;
                    case 3: p.setSituacao(EstadoProduto.VENDIDO); break;
                    case 4: p.setSituacao(EstadoProduto.FORA_ESTOQUE); break;
                }
                lista.add(p);
            }
            SingleConnection.close(rs, ps);
        } catch(SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        if(lista.isEmpty()) return null;
        return lista;

    }
    
    public List<Produto> precoEntreValores(Double min, Double max) throws SQLException {
    
        String sql = "select * from produtos where preco";
        sql += max == null? " >= "+min : " between "+min+" and "+max;
        sql += " and situacao = 1";
        return daoBase(sql);

    }
    
    public List<Produto> buscarNome(String nome) throws SQLException {
    
        String sql = "select * from produtos where nome like  '%"+nome+"%' and situacao = 1";
        return daoBase(sql);
        
    }
    
    public List<Produto> separaPorCategoria (String categoria) throws SQLException {
    
        String sql = "select * from produtos where categoria = '"+categoria+"' and situacao = 1";
        return daoBase(sql);
        
    }
    
    public List<Produto> separaPorSituacao (EstadoProduto estado) throws SQLException {
    
        String sql = "select * from produtos where situacao = "+estado.getType();
        return daoBase(sql);
        
    }
    
    public List<Produto> ordenaPorPreco() throws SQLException {
    
        String sql = "select * from produtos order by preco";
        return daoBase(sql);
    
    }
    
    public List<Produto> ordenaPorNome() throws SQLException {
    
        String sql = "select * from produtos order by nome";
        return daoBase(sql);
    
    }
    
    public List<String> getCategorias () throws SQLException {
        
        String sql = "select distinct categoria from produtos where situacao = 1 order by categoria";
        List<String> lista = new ArrayList<>();
                
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) lista.add(rs.getString("categoria"));
            SingleConnection.close(rs, ps);
        } catch(SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        if(lista.isEmpty()) return null;
        return lista;
        
    }
    
}
