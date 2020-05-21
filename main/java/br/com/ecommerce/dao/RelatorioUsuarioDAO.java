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
public class RelatorioUsuarioDAO {
 
    private Connection connection;

    public RelatorioUsuarioDAO() {
        connection = SingleConnection.getConnection();
    }
    
    public void gerarRelatorioUsuario(Integer id_usuario, Integer id_endereco, String path) throws SQLException {
    
        String sql = "copy(select usuarios.nome, email, cpf, rua, numero, cidade, cep, complemento,"
                + " produtos.nome as nome_produto, descricao, categoria, preco"
                + " from usuarios inner join enderecos on usuarios.id_usuario = enderecos.id_foreign"
                + " inner join produtos on produtos.id_foreign_produto = usuarios.id_usuario"
                + " where id_usuario = "+id_usuario+" and id_endereco = "+id_endereco+" and situacao = 2)"
                + " to '"+path+"' delimiter ';' csv header";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch(SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
    
    }
    
}
