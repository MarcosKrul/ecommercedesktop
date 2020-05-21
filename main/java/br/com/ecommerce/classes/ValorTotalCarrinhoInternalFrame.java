/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.classes;

import br.com.ecommerce.dao.ProdutoDAO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public abstract class ValorTotalCarrinhoInternalFrame extends PosicaoInternalFrame {
    
    public void setTotal(JLabel campo, Integer id, String inicio) {
        try {
            Double total = new ProdutoDAO().valorTotalCarrinho(id);
            campo.setText(inicio+new DecimalFormat("#,###.00").format(total));
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados ao calcular o total");
        }
    }
    
}
