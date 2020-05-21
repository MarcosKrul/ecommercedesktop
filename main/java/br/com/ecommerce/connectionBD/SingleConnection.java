/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.connectionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public abstract class SingleConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/e.commerce";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";
    private static Connection connection = null;

    static {
        conectar();
    }
    
    public static Connection getConnection() {
        conectar();
        return connection;
    }
    
    public static void close() throws SQLException {
        if(connection != null){
            connection.close();
            connection = null;
        }
    }
    
    public static void close (ResultSet rs) throws SQLException {
        close();
        if(rs != null) rs.close();
    }
    
    public static void close (PreparedStatement ps) throws SQLException {
        close();
        if(ps != null) ps.close();
    }
    
    public static void close (ResultSet rs, PreparedStatement ps) throws SQLException {
        close(rs);
        close(ps);
    }
    
    private static void conectar() {
        
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
            System.out.println("Erro sql");
        }
        
    }
}
