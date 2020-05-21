/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.compra;

import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.dao.InnerJoinProdutoUsuarioDAO;
import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.dao.RelatorioUsuarioDAO;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class TelaFinalizarCompra extends PosicaoInternalFrame {

    /**
     * Creates new form TelaFinalizarCompra
     */
    
    private Integer id_usuario;
    private Integer id_endereco;
    
    public TelaFinalizarCompra(Integer id_usuario, Integer id_endereco) {
        initComponents();
        setResizable(false);
        this.id_usuario = id_usuario;
        this.id_endereco = id_endereco;
    }
    
    private void limparCarrinho(){
        List<Produto> list = null;
        try {
            list = new InnerJoinProdutoUsuarioDAO().listaProdutosUsuario(id_usuario);
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        if(list == null) return;
        for(Produto aux: list){
            aux.setSituacao(EstadoProduto.VENDIDO);
            try{
                new ProdutoDAO().atualizarProduto(aux);
            } catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_finalizar_ok = new javax.swing.JButton();
        btn_finalizar_relatorio = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Compra finalizada com sucesso!!");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Agradecemos a preferência :)");

        btn_finalizar_ok.setBackground(new java.awt.Color(0, 153, 204));
        btn_finalizar_ok.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_finalizar_ok.setForeground(new java.awt.Color(255, 255, 255));
        btn_finalizar_ok.setText("OK");
        btn_finalizar_ok.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_finalizar_ok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_finalizar_ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_finalizar_okMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_finalizar_okMouseExited(evt);
            }
        });
        btn_finalizar_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizar_okActionPerformed(evt);
            }
        });

        btn_finalizar_relatorio.setBackground(new java.awt.Color(0, 153, 204));
        btn_finalizar_relatorio.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_finalizar_relatorio.setForeground(new java.awt.Color(255, 255, 255));
        btn_finalizar_relatorio.setText("Gerar relatório da compra");
        btn_finalizar_relatorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btn_finalizar_relatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_finalizar_relatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_finalizar_relatorioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_finalizar_relatorioMouseExited(evt);
            }
        });
        btn_finalizar_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizar_relatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_finalizar_ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_finalizar_relatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(59, 59, 59)
                .addComponent(btn_finalizar_ok, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_finalizar_relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void btn_finalizar_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizar_okActionPerformed
        limparCarrinho();
        dispose();
    }//GEN-LAST:event_btn_finalizar_okActionPerformed

    private void btn_finalizar_okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizar_okMouseEntered
        btn_finalizar_ok.setForeground(Color.BLACK);
        btn_finalizar_ok.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_finalizar_okMouseEntered

    private void btn_finalizar_okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizar_okMouseExited
        btn_finalizar_ok.setForeground(Color.WHITE);
        btn_finalizar_ok.setBackground(new Color(0,153,204));
    }//GEN-LAST:event_btn_finalizar_okMouseExited

    private void btn_finalizar_relatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizar_relatorioMouseEntered
        btn_finalizar_relatorio.setForeground(Color.BLACK);
        btn_finalizar_relatorio.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_finalizar_relatorioMouseEntered

    private void btn_finalizar_relatorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_finalizar_relatorioMouseExited
        btn_finalizar_relatorio.setForeground(Color.WHITE);
        btn_finalizar_relatorio.setBackground(new Color(0,153,204));
    }//GEN-LAST:event_btn_finalizar_relatorioMouseExited

    private void btn_finalizar_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizar_relatorioActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setMultiSelectionEnabled(false);
        int escolha = fileChooser.showSaveDialog(null);
        if(escolha == JFileChooser.APPROVE_OPTION){
            String dir = fileChooser.getSelectedFile().getAbsolutePath();
            if(!Files.isDirectory(Paths.get(dir))){
                JOptionPane.showMessageDialog(null, "Por favor, apenas selecione o local onde deseja salvar o relatório");
                return;
            }
            dir += dir.endsWith("\\")? "relatorio.csv" : "\\relatorio.csv";
            try{
                new RelatorioUsuarioDAO().gerarRelatorioUsuario(id_usuario, id_endereco, dir);
                JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!");
                limparCarrinho();
                dispose();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
        }
    }//GEN-LAST:event_btn_finalizar_relatorioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_finalizar_ok;
    private javax.swing.JButton btn_finalizar_relatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}