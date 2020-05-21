/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.estoque;

import br.com.ecommerce.classes.CarregaDadosModeloGerente;
import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.tables.ModeloMainGerente;
import java.awt.Color;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class TelaLimparEstoque extends PosicaoInternalFrame {

    /**
     * Creates new form TelaLimparEstoque
     */
    
    private final ModeloMainGerente MODELO;
    private final Map<Produto, Integer> MAP = new LinkedHashMap<>();
    
    public TelaLimparEstoque(ModeloMainGerente modelo) {
        initComponents();
        setResizable(false);
        this.MODELO = modelo;
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_limparEstoque_todas = new javax.swing.JButton();
        btn_limparEstoque_excetoUma = new javax.swing.JButton();
        btn_limparEstoque_cancelar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(18, 7, 67));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("A limpeza do estoque consiste em remover as unidades já vendidas.");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Você poderá:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("1) excluir todas as unidades que já foram vendidas; ou");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("2) deixar apenas uma unidade com estado FORA DE ESTOQUE, para que, ");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("posteriormente, seja possível aumentar a quantidade");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("deste produto em estoque.");

        btn_limparEstoque_todas.setBackground(new java.awt.Color(255, 0, 0));
        btn_limparEstoque_todas.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_limparEstoque_todas.setForeground(new java.awt.Color(255, 255, 255));
        btn_limparEstoque_todas.setText("Excluir todas as unidades vendidas");
        btn_limparEstoque_todas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_limparEstoque_todas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limparEstoque_todas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_limparEstoque_todasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_limparEstoque_todasMouseExited(evt);
            }
        });
        btn_limparEstoque_todas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparEstoque_todasActionPerformed(evt);
            }
        });

        btn_limparEstoque_excetoUma.setBackground(new java.awt.Color(255, 0, 0));
        btn_limparEstoque_excetoUma.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_limparEstoque_excetoUma.setForeground(new java.awt.Color(255, 255, 255));
        btn_limparEstoque_excetoUma.setText("Deixar apenas uma unidade");
        btn_limparEstoque_excetoUma.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_limparEstoque_excetoUma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limparEstoque_excetoUma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_limparEstoque_excetoUmaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_limparEstoque_excetoUmaMouseExited(evt);
            }
        });
        btn_limparEstoque_excetoUma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparEstoque_excetoUmaActionPerformed(evt);
            }
        });

        btn_limparEstoque_cancelar.setBackground(new java.awt.Color(0, 255, 0));
        btn_limparEstoque_cancelar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_limparEstoque_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limparEstoque_cancelar.setText("Cancelar");
        btn_limparEstoque_cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_limparEstoque_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limparEstoque_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_limparEstoque_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_limparEstoque_cancelarMouseExited(evt);
            }
        });
        btn_limparEstoque_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparEstoque_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_limparEstoque_todas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_limparEstoque_excetoUma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_limparEstoque_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(26, 26, 26)
                .addComponent(btn_limparEstoque_todas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_limparEstoque_excetoUma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_limparEstoque_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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

    private void btn_limparEstoque_todasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparEstoque_todasMouseEntered
        btn_limparEstoque_todas.setBackground(new Color(160,82,45));
    }//GEN-LAST:event_btn_limparEstoque_todasMouseEntered

    private void btn_limparEstoque_todasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparEstoque_todasMouseExited
        btn_limparEstoque_todas.setBackground(Color.RED);
    }//GEN-LAST:event_btn_limparEstoque_todasMouseExited

    private void btn_limparEstoque_excetoUmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparEstoque_excetoUmaMouseEntered
        btn_limparEstoque_excetoUma.setBackground(new Color(160,82,45));
    }//GEN-LAST:event_btn_limparEstoque_excetoUmaMouseEntered

    private void btn_limparEstoque_excetoUmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparEstoque_excetoUmaMouseExited
        btn_limparEstoque_excetoUma.setBackground(Color.RED);
    }//GEN-LAST:event_btn_limparEstoque_excetoUmaMouseExited

    private void btn_limparEstoque_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparEstoque_cancelarMouseEntered
        btn_limparEstoque_cancelar.setBackground(new Color(60,179,113));
    }//GEN-LAST:event_btn_limparEstoque_cancelarMouseEntered

    private void btn_limparEstoque_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limparEstoque_cancelarMouseExited
        btn_limparEstoque_cancelar.setBackground(Color.GREEN);
    }//GEN-LAST:event_btn_limparEstoque_cancelarMouseExited

    private void btn_limparEstoque_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparEstoque_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_limparEstoque_cancelarActionPerformed

    private void btn_limparEstoque_todasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparEstoque_todasActionPerformed
        
        List<Produto> list = null;
        try {
            list = new ProdutoDAO().listaProdutosVendidos();
            if(list == null){
                JOptionPane.showMessageDialog(null, "Não há produtos vendidos");
                return;
            } 
            for(Produto aux: list)
                new ProdutoDAO().deletarProduto(aux.getId_produto());
            JOptionPane.showMessageDialog(null, "Produtos excluídos com sucesso");
            new Thread(new CarregaDadosModeloGerente(MODELO)).start();
            dispose();
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        
    }//GEN-LAST:event_btn_limparEstoque_todasActionPerformed

    private void addProdutoMap(Produto p){
        for(Produto aux: MAP.keySet())
            if(aux.equals(p)){
                Integer qntOld = MAP.get(aux);
                MAP.replace(aux, qntOld, qntOld+1);
                return;
            }
        MAP.put(p, 1);
    }
    
    private void btn_limparEstoque_excetoUmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparEstoque_excetoUmaActionPerformed
        
        List<Produto> list = null;
        try {
            list = new ProdutoDAO().listaProdutosVendidos();
            if(list == null){
                JOptionPane.showMessageDialog(null, "Não há produtos vendidos");
                return;
            } 
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        
        for(Produto aux: list) addProdutoMap(aux);
        for(Map.Entry<Produto, Integer> entry : MAP.entrySet()){
            if(entry.getValue() == 1){
                int resposta = JOptionPane.showConfirmDialog(null, "O produto: '"+entry.getKey().getNome()+
                        "' possui apenas um unidade\nDeseja excluí-la?", 
                        "Confirmação de limpeza", JOptionPane.YES_NO_OPTION);
                if(resposta == JOptionPane.YES_OPTION){
                    try {
                        new ProdutoDAO().deletarProduto(entry.getKey().getId_produto());
                        JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                        new Thread(new CarregaDadosModeloGerente(MODELO)).start();
                        dispose();
                    } catch (SQLException e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
                    }
                } else continue;
            } else {
                List<Produto> lista = null;
                Produto p = entry.getKey();
                try {
                    lista = new ProdutoDAO().unidadesMesmoProduto(p.getNome(), p.getDescricao(), 
                            p.getCategoria(), p.getPreco());
                } catch (SQLException e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
                }
                for(int i=0 ; i<(lista.size()-1) ; i++){
                    try {
                        new ProdutoDAO().deletarProduto(lista.get(i).getId_produto());
                    } catch (SQLException e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
                    }
                }
                JOptionPane.showMessageDialog(null, "Produtos excluídos com sucesso!");
                new Thread(new CarregaDadosModeloGerente(MODELO)).start();
                dispose();
            }
        }
        
    }//GEN-LAST:event_btn_limparEstoque_excetoUmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_limparEstoque_cancelar;
    private javax.swing.JButton btn_limparEstoque_excetoUma;
    private javax.swing.JButton btn_limparEstoque_todas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}