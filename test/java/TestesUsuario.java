
import br.com.ecommerce.classes.Usuario;
import br.com.ecommerce.dao.UsuarioDAO;
import br.com.ecommerce.enumeracoes.TipoUsuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class TestesUsuario {
    
    
    @Test
    public void adicionarUsuario () {
        UsuarioDAO uD = new UsuarioDAO();
        Usuario g = new Usuario("Joao", "456.789.113-56", "joao@gmail.com", TipoUsuario.USUARIO_GERENTE);
        g.setPassword("jaoozao");
        Usuario c = new Usuario("Marcio", "456.111.036-99", "marciomm@hotmail.com", TipoUsuario.USUARIO_CONSUMIDOR);
        c.setPassword("marciofoda");
        try {
            uD.addUsuario(g);
            uD = new UsuarioDAO();
            uD.addUsuario(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void deletarUsuario() {
        UsuarioDAO uD = new UsuarioDAO();
        try {
            uD.deletarUsuario(3);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void atualizaUsuario() {
        UsuarioDAO uD = new UsuarioDAO();
        Usuario c = new Usuario("Marcio silva", "marcio@gmail.com", "456.222.036-99");
        c.setId(4);
        try {
            uD.atualizarUsuario(c);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void procuraUsuario() {
        UsuarioDAO uD = new UsuarioDAO();
        List<Usuario> lista = new ArrayList<>();
        try {
            lista = uD.listaUsuarios(false, 4);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(lista);
    }
    
    @Test
    public void vetor() {
        int count = 0;
        char[] um = {'a', 'n', 'a'};
        char[] dois = {'a', 'n', 'b'};
        
        System.out.println("----------");
        System.out.println(um);
        System.out.println("----------");
        System.out.println(dois);
        System.out.println("----------");
        for(int i=0 ; i<um.length ; i++)
            if(um[i] == dois[i]) count ++;
        System.out.println(count == um.length);
    }
}
