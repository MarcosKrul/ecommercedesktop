/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.dao;

import br.com.ecommerce.classes.Usuario;
import br.com.ecommerce.connectionBD.SingleConnection;
import br.com.ecommerce.enumeracoes.TipoUsuario;
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
public class UsuarioDAO {
    
    private Connection connection;

    public UsuarioDAO() {
        connection = SingleConnection.getConnection();
    }
    
    public void addUsuario (Usuario usuario) throws SQLException {
    
        String sql = "insert into usuarios (cpf,nome,email,password,tipo_usuario) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getPassword());
            ps.setInt(5, usuario.getTipo().getType());
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        } 
        
    }
    
    public void deletarUsuario (Integer id) throws SQLException {
    
        String sql = "delete from usuarios where id_usuario = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        } 
        
    }
    
    public void atualizarUsuario (Usuario usuario) throws SQLException {
    
        if(usuario == null || usuario.getId() == null) return;
        String sql = "update usuarios set cpf=?,nome=?,email=?,password=? where id_usuario=?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(5, usuario.getId());
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getPassword());
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        } 
        
    }
    
    public List<Usuario> listaUsuarios(boolean todos, Integer unico) throws SQLException {
        
        Usuario usuario = null;
        List<Usuario> lista = new ArrayList<>();
        String sql = "select * from usuarios";
        if(!todos) sql += " where id_usuario = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            if(!todos) ps.setInt(1, unico);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTipo(rs.getInt("tipo_usuario")==1?TipoUsuario.USUARIO_CONSUMIDOR:TipoUsuario.USUARIO_GERENTE);
                lista.add(usuario);
            }
            SingleConnection.close(rs, ps);
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        if(lista.isEmpty()) return null;
        return lista;
    
    }
    
    public Integer getIdGerente () throws SQLException {
        
        String sql = "select id_usuario from usuarios where tipo_usuario = 2";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Integer id = rs.getInt("id_usuario");
            SingleConnection.close(rs, ps);
            return id;
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        
    }
    
}
