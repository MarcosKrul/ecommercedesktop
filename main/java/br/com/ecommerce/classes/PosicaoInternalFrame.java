/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.classes;

import java.awt.Dimension;

/**
 *
 * @author marco
 */
public class PosicaoInternalFrame extends javax.swing.JInternalFrame {

    // A implementação do método foi retirada de:
    // https://www.guj.com.br/t/resolvido-centralizar-jinternalframe/236543
    // Código de autoria de JuniorMaia
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

}
