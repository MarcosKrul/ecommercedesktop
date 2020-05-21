/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.classes;

import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.tables.ModeloMainGerente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class CarregaDadosModeloGerente implements Runnable{

    private final ModeloMainGerente MODELO;

    public CarregaDadosModeloGerente(ModeloMainGerente modelo) {
        this.MODELO = modelo;
    }
    
    @Override
    public void run() {
        synchronized(MODELO){
            List<Produto> listaTabela = null;
            try {
                listaTabela = new ProdutoDAO().listaProdutosUsuario(true, -1);
            } catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
            if(listaTabela != null) MODELO.setDados(listaTabela);
        }
    }
    
}
