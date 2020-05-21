
import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import java.sql.SQLException;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marco
 */
public class TestesProdutos {
    
    @Test
    public void add() throws SQLException {
        Produto p = new Produto("Lapis", "Escola", 2.50D, EstadoProduto.ESTOQUE);
        p.setDescricao("lapis fb 2b");
        p.setId_foreign(11);
        ProdutoDAO pD = new ProdutoDAO();
        pD.addProduto(p);
    }
    
    @Test
    public void delete() throws SQLException {
        new ProdutoDAO().deletarProduto(16);
    
    }
    
    @Test
    public void lista() throws SQLException{
        for(Produto aux: new ProdutoDAO().listaProdutosUsuario(true, -1))
            System.out.println(aux);
    }
    
}
