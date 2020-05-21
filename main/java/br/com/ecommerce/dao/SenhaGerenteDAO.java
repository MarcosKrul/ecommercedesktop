/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.dao;

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
public class SenhaGerenteDAO {
    
    private Connection connection;

    public SenhaGerenteDAO() {
        connection = SingleConnection.getConnection();
    }
    
    public List<String> senhas () throws SQLException {
    
        String sql = "select password from senhagerente";
        List<String> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) lista.add(rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        if(lista.isEmpty()) return null;
        return lista;
    }
    
    
}
