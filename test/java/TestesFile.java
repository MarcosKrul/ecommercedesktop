
import br.com.ecommerce.file.FileRelatorio;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
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
public class TestesFile {
    
//    @Test
    public List<String> linhas() throws IOException {
        List<String> list = new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader("D:\\relatorio.csv"))){
            String linha;
            while((linha = bf.readLine()) != null) list.add(linha);
        }
        return list;
    }
    
    @Test
    public void completar() throws IOException {
        Calendar c = Calendar.getInstance();
        String DATA = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
        String HORA = new SimpleDateFormat("HH:mm:ss").format(c.getTime());
        List<String> conteudo = linhas();
        conteudo.set(0, conteudo.get(0)+";data;hora");
        for(int i=1 ; i<conteudo.size() ; i++)
            conteudo.set(i, conteudo.get(i)+";"+DATA+";"+HORA);
        for(String aux: conteudo) System.out.println(aux);
    }
    
    @Test
    public void teste() throws FileNotFoundException, IOException {
        new FileRelatorio("D:\\relatorio.csv").completarRelatorioUsuario();
    
    }
    
}
