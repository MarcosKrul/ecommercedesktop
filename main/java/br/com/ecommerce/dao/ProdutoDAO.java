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
public class ProdutoDAO {
    
    private Connection connection;

    public ProdutoDAO() {
        connection = SingleConnection.getConnection();
    }
    
    public void addProduto(Produto p) throws SQLException {
        
        String sql = "insert into produtos(id_foreign_produto,preco,situacao,nome,categoria,descricao) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, p.getId_foreign());
            ps.setDouble(2, p.getPreco());
            ps.setInt(3, p.getSituacao().getType());
            ps.setString(4, p.getNome());
            ps.setString(5, p.getCategoria());
            ps.setString(6, p.getDescricao());
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
    
    }
    
    public void deletarProduto(Integer id) throws SQLException {
        
        String sql = "delete from produtos where id_produto=?";
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
    
    public void atualizarProduto(Produto p) throws SQLException {
        
        if(p == null || p.getId_produto() == null) return;
        String sql = "update produtos set id_foreign_produto=?,preco=?,situacao=?,nome=?,categoria=?,descricao=? "
                + "where id_produto = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(7, p.getId_produto());
            ps.setInt(1, p.getId_foreign());
            ps.setDouble(2, p.getPreco());
            ps.setInt(3, p.getSituacao().getType());
            ps.setString(4, p.getNome());
            ps.setString(5, p.getCategoria());
            ps.setString(6, p.getDescricao());
            ps.execute();
            connection.commit();
            SingleConnection.close(ps);
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
    
    }
    
    private List<Produto> baseProcuraProdutos (String sql) throws SQLException {
        
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
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        if(lista.isEmpty()) return null;
        return lista;
    
    }
    
    public List<Produto> listaProdutosUsuario(boolean todos, Integer id) throws SQLException {
    
        String sql = "select * from produtos";
        if(!todos) {sql += " where id_foreign_produto = "+id+" and situacao = 2";}
        return baseProcuraProdutos(sql);
        
    }
    
    public List<Produto> listaProdutosDisponiveis(String nomeProduto) throws SQLException {
    
        String sql = "select * from produtos where situacao = 1 and nome = '"+nomeProduto+"'";
        return baseProcuraProdutos(sql);
        
    }
    
    public List<Produto> listaProdutosVendidos() throws SQLException {
    
        String sql = "select * from produtos where situacao = 3";
        return baseProcuraProdutos(sql);
        
    }
    
    public List<Produto> unidadesCarrinho(Integer id, String nomeProduto) throws SQLException {
    
        String sql = "select * from produtos where id_foreign_produto = "+id+" and nome = '"+nomeProduto+"'";
        return baseProcuraProdutos(sql);
        
    }
    
    public List<Produto> unidadesMesmoProduto(String nome, String desc, String categoria, Double preco) throws SQLException {
        
        String sql = "select * from produtos where nome='"+nome+"' and descricao='"+desc+"' and "+
                "categoria='"+categoria+"' and preco = "+preco;
        return baseProcuraProdutos(sql);
        
    }

    public Double valorTotalCarrinho (Integer id_usuario) throws SQLException {
    
        String sql = "select sum(preco) as total_carrinho from produtos where id_foreign_produto = "+id_usuario
                + "  and situacao = 2";
        Double total = null;
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            total = rs.getDouble("total_carrinho");
            SingleConnection.close(rs, ps);
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new SQLException();
        }
        return total;

    }
    
}
