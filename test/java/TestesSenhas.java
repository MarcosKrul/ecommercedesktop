
import br.com.ecommerce.dao.SenhaGerenteDAO;
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
public class TestesSenhas {
    
    
    @Test
    public void senhas () throws SQLException {
        System.out.println(new SenhaGerenteDAO().senhas());
                
    
    }
}
