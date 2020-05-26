/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.classes;

import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import br.com.ecommerce.tables.ModeloMainUsuario;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class CarregaDadosModeloUsuario implements Runnable{

    private final ModeloMainUsuario MODELO;

    public CarregaDadosModeloUsuario(ModeloMainUsuario MODELO) {
        this.MODELO = MODELO;
    }
    
    @Override
    public void run() {
        synchronized(MODELO){
            MODELO.clearMap();
            try {
                List<Produto> lista;
                if((lista = new ProdutoDAO().listaProdutosUsuario(true, -1)) != null)
                    for(Produto aux : lista)
                        if(aux.getSituacao() == EstadoProduto.ESTOQUE)
                            MODELO.addProduto(aux, false);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
        }
    }
    
}
