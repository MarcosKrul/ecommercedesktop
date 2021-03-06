/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view;

import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.tables.ModeloMainGerente;
import br.com.ecommerce.view.att.produto.TelaAtualizarProduto;
import br.com.ecommerce.view.delete.produto.TelaDeletarProduto;
import java.awt.Color;
import javax.swing.JDesktopPane;

/**
 *
 * @author marco
 */
public class TelaUnicoOuTodos extends PosicaoInternalFrame {

    /**
     * Creates new form TelaUnicoOuTodos
     */
    
    private final int index;
    private final JDesktopPane desktop;
    private final ModeloMainGerente MODELO;
    private final Integer PROXIMA_TELA; // 1- para atualizar; 2- para deletar
    
    public TelaUnicoOuTodos(int index, Integer proximaTela, JDesktopPane desktop, ModeloMainGerente modelo) {
        initComponents();
        setResizable(false);
        this.index = index;
        this.desktop = desktop;
        this.MODELO = modelo;
        this.PROXIMA_TELA = proximaTela;
        switch(PROXIMA_TELA) {
            case 1:
                btn_unicoOuTodos_unidade.setText("Atualizar apenas a unidade selecionada");
                btn_unicoOuTodos_todos.setText("Atualizar todas as unidades do produto");
                break;
            case 2:
                btn_unicoOuTodos_unidade.setText("Excluir apenas a unidade selecionada");
                btn_unicoOuTodos_todos.setText("Excluir todas as unidades do produto");
                break;
            default: System.out.println("opção inválida para próxima tela"); break;
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
        btn_unicoOuTodos_unidade = new javax.swing.JButton();
        btn_unicoOuTodos_todos = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        btn_unicoOuTodos_unidade.setBackground(new java.awt.Color(255, 255, 255));
        btn_unicoOuTodos_unidade.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_unicoOuTodos_unidade.setForeground(new java.awt.Color(0, 51, 153));
        btn_unicoOuTodos_unidade.setText("jButton1");
        btn_unicoOuTodos_unidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_unicoOuTodos_unidadeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_unicoOuTodos_unidadeMouseExited(evt);
            }
        });
        btn_unicoOuTodos_unidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_unicoOuTodos_unidadeActionPerformed(evt);
            }
        });

        btn_unicoOuTodos_todos.setBackground(new java.awt.Color(255, 255, 255));
        btn_unicoOuTodos_todos.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_unicoOuTodos_todos.setForeground(new java.awt.Color(0, 51, 153));
        btn_unicoOuTodos_todos.setText("jButton2");
        btn_unicoOuTodos_todos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_unicoOuTodos_todosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_unicoOuTodos_todosMouseExited(evt);
            }
        });
        btn_unicoOuTodos_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_unicoOuTodos_todosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_unicoOuTodos_unidade, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                    .addComponent(btn_unicoOuTodos_todos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_unicoOuTodos_unidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_unicoOuTodos_todos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_unicoOuTodos_unidadeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_unicoOuTodos_unidadeMouseEntered
        btn_unicoOuTodos_unidade.setForeground(Color.RED);
    }//GEN-LAST:event_btn_unicoOuTodos_unidadeMouseEntered

    private void btn_unicoOuTodos_unidadeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_unicoOuTodos_unidadeMouseExited
        btn_unicoOuTodos_unidade.setForeground(new Color(0,51,153));
    }//GEN-LAST:event_btn_unicoOuTodos_unidadeMouseExited

    private void btn_unicoOuTodos_todosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_unicoOuTodos_todosMouseEntered
        btn_unicoOuTodos_todos.setForeground(Color.RED);
    }//GEN-LAST:event_btn_unicoOuTodos_todosMouseEntered

    private void btn_unicoOuTodos_todosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_unicoOuTodos_todosMouseExited
        btn_unicoOuTodos_todos.setForeground(new Color(0,51,153));
    }//GEN-LAST:event_btn_unicoOuTodos_todosMouseExited

    private void suporteCarregaTela(boolean todos){
        PosicaoInternalFrame tela = null;
        if(PROXIMA_TELA == 1)
            tela = new TelaAtualizarProduto(todos, index, MODELO);
        else tela = new TelaDeletarProduto(todos, MODELO.getProdutoIndex(index), MODELO);
        
        desktop.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
        dispose();
    }
    
    private void btn_unicoOuTodos_unidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_unicoOuTodos_unidadeActionPerformed
        suporteCarregaTela(false);
    }//GEN-LAST:event_btn_unicoOuTodos_unidadeActionPerformed

    private void btn_unicoOuTodos_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_unicoOuTodos_todosActionPerformed
        suporteCarregaTela(true);
    }//GEN-LAST:event_btn_unicoOuTodos_todosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_unicoOuTodos_todos;
    private javax.swing.JButton btn_unicoOuTodos_unidade;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
