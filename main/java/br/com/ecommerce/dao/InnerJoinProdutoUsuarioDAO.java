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
public class InnerJoinProdutoUsuarioDAO {
    
    private Connection connection;

    public InnerJoinProdutoUsuarioDAO() {
        connection = SingleConnection.getConnection();
    }
    
    public List<Produto> listaProdutosUsuario (Integer id_usuario) throws SQLException{
    
        Produto p = null;
        List<Produto> lista = new ArrayList<>();
        String sql = "select * from produtos inner join usuarios on "
                + "produtos.id_foreign_produto = usuarios.id_usuario where id_usuario = ? and produtos.situacao = 2";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_usuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p = new Produto();
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setCategoria(rs.getString("categoria"));
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
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        if(lista.isEmpty()) return null;
        return lista;
        
    }
    
    
}
