
import br.com.ecommerce.dao.InformacoesGerenteDAO;
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
public class TestesInformacoes {
    
    @Test
    public void info1 () throws SQLException{
        System.out.println(new InformacoesGerenteDAO().valorTotalProdutos(EstadoProduto.ESTOQUE));
    }
    @Test
    public void info2 () throws SQLException{
        System.out.println(new InformacoesGerenteDAO().quantidadeTotalProdutos(EstadoProduto.ESTOQUE));
    }
    @Test
    public void info3 () throws SQLException{
        System.out.println(new InformacoesGerenteDAO().valorPorProduto(EstadoProduto.ESTOQUE));
    }
    
}
