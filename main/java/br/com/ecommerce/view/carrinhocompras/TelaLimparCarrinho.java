/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.carrinhocompras;

import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.dao.UsuarioDAO;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import br.com.ecommerce.tables.ModeloMainUsuario;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class TelaLimparCarrinho extends PosicaoInternalFrame {

    /**
     * Creates new form TelaLimparCarrinho
     */
    private Integer id_usuario;
    private ModeloMainUsuario modeloMain;
    
    public TelaLimparCarrinho(Integer id, ModeloMainUsuario modelo) {
        initComponents();
        setResizable(false);
        this.id_usuario = id;
        this.modeloMain = modelo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_clearcarrinho_nao = new javax.swing.JButton();
        btn_clearcarrinho_sim = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setBackground(new java.awt.Color(18, 7, 67));
        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ao limpar seu carrinho, todos os produtos nele existentes");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("irão voltar à lista principal, onde poderão ser");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("adquiridos por outros usuários.");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Você tem certeza que deseja limpar seu carrinho?");

        btn_clearcarrinho_nao.setBackground(new java.awt.Color(255, 255, 255));
        btn_clearcarrinho_nao.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_clearcarrinho_nao.setText("Não, desejo manter meu carrinho");
        btn_clearcarrinho_nao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clearcarrinho_nao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clearcarrinho_nao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_clearcarrinho_naoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_clearcarrinho_naoMouseExited(evt);
            }
        });
        btn_clearcarrinho_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearcarrinho_naoActionPerformed(evt);
            }
        });

        btn_clearcarrinho_sim.setBackground(new java.awt.Color(255, 255, 255));
        btn_clearcarrinho_sim.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_clearcarrinho_sim.setText("Sim, desejo limpar meu carrinho");
        btn_clearcarrinho_sim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clearcarrinho_sim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clearcarrinho_sim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_clearcarrinho_simMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_clearcarrinho_simMouseExited(evt);
            }
        });
        btn_clearcarrinho_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearcarrinho_simActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_clearcarrinho_nao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_clearcarrinho_sim, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(btn_clearcarrinho_nao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_clearcarrinho_sim, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearcarrinho_naoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearcarrinho_naoMouseEntered
        btn_clearcarrinho_nao.setBackground(Color.GREEN);
        btn_clearcarrinho_nao.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_clearcarrinho_naoMouseEntered

    private void btn_clearcarrinho_naoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearcarrinho_naoMouseExited
        btn_clearcarrinho_nao.setBackground(Color.WHITE);
        btn_clearcarrinho_nao.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_clearcarrinho_naoMouseExited

    private void btn_clearcarrinho_simMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearcarrinho_simMouseEntered
        btn_clearcarrinho_sim.setBackground(Color.RED);
        btn_clearcarrinho_sim.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_clearcarrinho_simMouseEntered

    private void btn_clearcarrinho_simMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearcarrinho_simMouseExited
        btn_clearcarrinho_sim.setBackground(Color.WHITE);
        btn_clearcarrinho_sim.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_clearcarrinho_simMouseExited

    private void btn_clearcarrinho_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearcarrinho_naoActionPerformed
        dispose();
    }//GEN-LAST:event_btn_clearcarrinho_naoActionPerformed

    private void btn_clearcarrinho_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearcarrinho_simActionPerformed

        List<Produto> lista = null;
        try {
            lista = new ProdutoDAO().listaProdutosUsuario(false, id_usuario);
            if(lista == null){
                JOptionPane.showMessageDialog(null, "O carrinho já está vazio");
                dispose();
                return;
            }
            for(Produto aux : lista){
                aux.setSituacao(EstadoProduto.ESTOQUE);
                aux.setId_foreign(new UsuarioDAO().getIdGerente());
                new ProdutoDAO().atualizarProduto(aux);
                modeloMain.addProduto(aux, false);
            }
            JOptionPane.showMessageDialog(null, "Carrinho esvaziado com sucesso!");
            dispose();
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        
    }//GEN-LAST:event_btn_clearcarrinho_simActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clearcarrinho_nao;
    private javax.swing.JButton btn_clearcarrinho_sim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
