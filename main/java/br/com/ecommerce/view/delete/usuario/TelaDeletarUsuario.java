/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.delete.usuario;

import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.dao.ExcluirEnderecosUsuarioDAO;
import br.com.ecommerce.dao.InnerJoinProdutoUsuarioDAO;
import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.dao.UsuarioDAO;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class TelaDeletarUsuario extends PosicaoInternalFrame {

    /**
     * Creates new form TelaDeletarUsuario
     */
    
    private Integer id;
    
    public TelaDeletarUsuario(Integer id) {
        initComponents();
        this.id = id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_deletarUsuario_excluir = new javax.swing.JButton();
        btn_deletarUsuario_cancelar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(18, 7, 67));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ao excluir a sua conta, todos os seus dados serão perdidos e seu ");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("carrinho de compras será esvaziado.");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Você tem certeza que deseja excluir sua conta? ");

        btn_deletarUsuario_excluir.setBackground(new java.awt.Color(255, 0, 0));
        btn_deletarUsuario_excluir.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_deletarUsuario_excluir.setForeground(new java.awt.Color(255, 255, 255));
        btn_deletarUsuario_excluir.setText("Sim, desejo excluir minha conta");
        btn_deletarUsuario_excluir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_deletarUsuario_excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_deletarUsuario_excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_deletarUsuario_excluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_deletarUsuario_excluirMouseExited(evt);
            }
        });
        btn_deletarUsuario_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletarUsuario_excluirActionPerformed(evt);
            }
        });

        btn_deletarUsuario_cancelar.setBackground(new java.awt.Color(0, 255, 0));
        btn_deletarUsuario_cancelar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_deletarUsuario_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_deletarUsuario_cancelar.setText("Não, quero manter a minha conta ativa");
        btn_deletarUsuario_cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_deletarUsuario_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_deletarUsuario_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_deletarUsuario_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_deletarUsuario_cancelarMouseExited(evt);
            }
        });
        btn_deletarUsuario_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deletarUsuario_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_deletarUsuario_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_deletarUsuario_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(33, 33, 33)
                .addComponent(btn_deletarUsuario_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_deletarUsuario_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deletarUsuario_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletarUsuario_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_deletarUsuario_cancelarActionPerformed

    private void btn_deletarUsuario_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deletarUsuario_excluirActionPerformed
        try {
            for(Produto aux : new InnerJoinProdutoUsuarioDAO().listaProdutosUsuario(id)){
                aux.setSituacao(EstadoProduto.ESTOQUE);
                aux.setId_foreign(new UsuarioDAO().getIdGerente());
                new ProdutoDAO().atualizarProduto(aux);
            }
            new ExcluirEnderecosUsuarioDAO().deletarEnderecos(id);
            JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");
            System.exit(0);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
    }//GEN-LAST:event_btn_deletarUsuario_excluirActionPerformed

    private void btn_deletarUsuario_excluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deletarUsuario_excluirMouseEntered
        btn_deletarUsuario_excluir.setBackground(new Color(160,82,45));
    }//GEN-LAST:event_btn_deletarUsuario_excluirMouseEntered

    private void btn_deletarUsuario_excluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deletarUsuario_excluirMouseExited
        btn_deletarUsuario_excluir.setBackground(Color.RED);
    }//GEN-LAST:event_btn_deletarUsuario_excluirMouseExited

    private void btn_deletarUsuario_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deletarUsuario_cancelarMouseEntered
        btn_deletarUsuario_cancelar.setBackground(new Color(60,179,113));
    }//GEN-LAST:event_btn_deletarUsuario_cancelarMouseEntered

    private void btn_deletarUsuario_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deletarUsuario_cancelarMouseExited
        btn_deletarUsuario_cancelar.setBackground(Color.GREEN);
    }//GEN-LAST:event_btn_deletarUsuario_cancelarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deletarUsuario_cancelar;
    private javax.swing.JButton btn_deletarUsuario_excluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}