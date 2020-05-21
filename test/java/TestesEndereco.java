
import br.com.ecommerce.classes.Endereco;
import br.com.ecommerce.dao.EnderecoDAO;
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
public class TestesEndereco {
 
    @Test
    public void adicionar () throws SQLException {
        Endereco e = new Endereco("robson", "chuvopolis", "45862-007", "26");
        e.setId_foreign(4);
        EnderecoDAO eD = new EnderecoDAO();
        eD.addEndereco(e);
    
    }
    
    @Test
    public void deletar () throws SQLException {
        EnderecoDAO eD = new EnderecoDAO();
        eD.deletarEndereco(5);
        
    }
    
    @Test
    public void atualizar () throws SQLException {
    
        Endereco e = new Endereco("jorge worel", "pedropolis", "456985-955", "20");
        e.setComplemento("apt 47");
        e.setId_endereco(6);
        e.setId_foreign(4);
        EnderecoDAO eD = new EnderecoDAO();
        eD.atualizarEndereco(e);
    }
    
    @Test
    public void lista () throws SQLException {
        EnderecoDAO eD = new EnderecoDAO();
        System.out.println(eD.listaEnderecos(false, 4));
    }
    
    
}
