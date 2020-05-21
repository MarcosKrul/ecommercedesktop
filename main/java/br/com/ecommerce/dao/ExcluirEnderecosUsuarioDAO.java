/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.dao;

import br.com.ecommerce.connectionBD.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class ExcluirEnderecosUsuarioDAO {
    
    private Connection connection;

    public ExcluirEnderecosUsuarioDAO() {
        connection = SingleConnection.getConnection();
    }
    
    public void deletarEnderecos(Integer id_usuario) throws SQLException{
        
        String sql = "delete from enderecos where id_foreign = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
            new UsuarioDAO().deletarUsuario(id_usuario);
        } catch(SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }  
        
    }
    
    
    
}
