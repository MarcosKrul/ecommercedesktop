/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.dao;

import br.com.ecommerce.classes.Endereco;
import br.com.ecommerce.connectionBD.SingleConnection;
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
public class EnderecoDAO {
    
    private Connection connection;

    public EnderecoDAO() {
        connection = SingleConnection.getConnection();
    }
    
    public void addEndereco (Endereco e) throws SQLException {
    
        String sql = "insert into enderecos (id_foreign,cep,rua,cidade,complemento,numero) values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, e.getId_foreign());
            ps.setString(2, e.getCep());
            ps.setString(3, e.getRua());
            ps.setString(4, e.getCidade());
            ps.setString(5, e.getComplemento());
            ps.setString(6, e.getNumero());
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
    
    }
    
    public void deletarEndereco (Integer id) throws SQLException {
    
        String sql = "delete from enderecos where id_endereco = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }

    }
    
    public void atualizarEndereco (Endereco e) throws SQLException {
    
        if(e == null || e.getId_endereco() == null) return;
        String sql = "update enderecos set rua=?,cidade=?,cep=?,complemento=?,numero=? where id_endereco = "+e.getId_endereco();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, e.getRua());
            ps.setString(2, e.getCidade());
            ps.setString(3, e.getCep());
            ps.setString(4, e.getComplemento());
            ps.setString(5, e.getNumero());
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
    
    }
    
    public List<Endereco> listaEnderecos (boolean todos, Integer unico) throws SQLException {
    
        String sql = "select * from enderecos";
        if(!todos) sql += " where id_foreign = ?";
        List<Endereco> lista = new ArrayList<>();
        Endereco teste = null;
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            if(!todos) ps.setInt(1, unico);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                teste = new Endereco();
                teste.setCep(rs.getString("cep"));
                teste.setRua(rs.getString("rua"));
                teste.setCidade(rs.getString("cidade"));
                teste.setComplemento(rs.getString("complemento"));
                teste.setNumero(rs.getString("numero"));
                teste.setId_endereco(rs.getInt("id_endereco"));
                teste.setId_foreign(rs.getInt("id_foreign"));
                lista.add(teste);
            }
            SingleConnection.close(rs, ps);
        } catch (SQLException ex) {
            ex.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        return lista;
        
    }
    
}
