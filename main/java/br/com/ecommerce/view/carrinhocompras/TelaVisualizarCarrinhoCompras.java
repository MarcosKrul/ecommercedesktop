/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.carrinhocompras;

import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.classes.ValorTotalCarrinhoInternalFrame;
import br.com.ecommerce.dao.InnerJoinProdutoUsuarioDAO;
import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.dao.UsuarioDAO;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import br.com.ecommerce.tables.ModeloMainUsuario;
import br.com.ecommerce.tables.ModeloVisualizarCarrinho;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class TelaVisualizarCarrinhoCompras extends ValorTotalCarrinhoInternalFrame {

    /**
     * Creates new form TelaVisualizarCarrinhoCompras
     */
    
    private Integer id_usuario;
    private ModeloVisualizarCarrinho modelo;
    private ModeloMainUsuario modeloMainProdutos;
    
    public TelaVisualizarCarrinhoCompras(Integer id, ModeloMainUsuario model) {
        initComponents();
        this.id_usuario = id;
        this.modeloMainProdutos = model;
        modelo = new ModeloVisualizarCarrinho();
        tabela_viewcarrinho.setModel(modelo);
        setResizable(false);
        setTotal(cp_viewcarrinho_total, id_usuario,"");
        List<Produto> lista = null;
        try {
            lista = new InnerJoinProdutoUsuarioDAO().listaProdutosUsuario(id);
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        if(lista != null) for(Produto aux : lista) modelo.addProduto(aux);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_viewcarrinho = new javax.swing.JTable();
        btn_viewcarrinho_remover = new javax.swing.JButton();
        btn_viewcarrinho_continuar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cp_viewcarrinho_total = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(18, 7, 67));

        tabela_viewcarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela_viewcarrinho);

        btn_viewcarrinho_remover.setBackground(new java.awt.Color(255, 255, 255));
        btn_viewcarrinho_remover.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_viewcarrinho_remover.setText("Remover item do carrinho");
        btn_viewcarrinho_remover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_viewcarrinho_remover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_viewcarrinho_remover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewcarrinho_removerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewcarrinho_removerMouseExited(evt);
            }
        });
        btn_viewcarrinho_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewcarrinho_removerActionPerformed(evt);
            }
        });

        btn_viewcarrinho_continuar.setBackground(new java.awt.Color(255, 255, 255));
        btn_viewcarrinho_continuar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_viewcarrinho_continuar.setText("Continuar comprando");
        btn_viewcarrinho_continuar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_viewcarrinho_continuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_viewcarrinho_continuar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_viewcarrinho_continuarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_viewcarrinho_continuarMouseExited(evt);
            }
        });
        btn_viewcarrinho_continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewcarrinho_continuarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Valor total do carrinho:");

        cp_viewcarrinho_total.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        cp_viewcarrinho_total.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btn_viewcarrinho_remover, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_viewcarrinho_continuar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cp_viewcarrinho_total, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cp_viewcarrinho_total, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_viewcarrinho_remover, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btn_viewcarrinho_continuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
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

    private void btn_viewcarrinho_removerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewcarrinho_removerMouseEntered
        btn_viewcarrinho_remover.setBackground(Color.RED);
        btn_viewcarrinho_remover.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_viewcarrinho_removerMouseEntered

    private void btn_viewcarrinho_removerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewcarrinho_removerMouseExited
        btn_viewcarrinho_remover.setBackground(Color.WHITE);
        btn_viewcarrinho_remover.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_viewcarrinho_removerMouseExited

    private void btn_viewcarrinho_continuarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewcarrinho_continuarMouseEntered
        btn_viewcarrinho_continuar.setBackground(Color.GREEN);
        btn_viewcarrinho_continuar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_viewcarrinho_continuarMouseEntered

    private void btn_viewcarrinho_continuarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_viewcarrinho_continuarMouseExited
        btn_viewcarrinho_continuar.setBackground(Color.WHITE);
        btn_viewcarrinho_continuar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_viewcarrinho_continuarMouseExited

    private void btn_viewcarrinho_continuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewcarrinho_continuarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_viewcarrinho_continuarActionPerformed

    private void btn_viewcarrinho_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewcarrinho_removerActionPerformed
        
        int index = tabela_viewcarrinho.getSelectedRow();
        if(index == -1){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um produto para removê-lo do carrinho");
            return;
        }
        
        Produto p = modelo.getProdutoIndex(index);
        if(modelo.quantidadeProduto(p) == 1) {
            p.setSituacao(EstadoProduto.ESTOQUE);
            try {
                p.setId_foreign(new UsuarioDAO().getIdGerente());
                new ProdutoDAO().atualizarProduto(p);
                JOptionPane.showMessageDialog(null, "Item removido do carrinho com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
            modelo.removeProduto(p);
            modeloMainProdutos.addProduto(p, false);
        } else {
            Integer quantidadeOld = modelo.quantidadeProduto(p);
            Integer quantidade = null;
            String input = JOptionPane.showInputDialog("Quantas unidades deseja remover?");
            if(input == null) return;
            try{
                quantidade = Integer.parseInt(input);
            } catch (NumberFormatException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Valor inválido");
                return;
            }
            
            List<Produto> produtos = null;
            try{
                produtos = new ProdutoDAO().unidadesCarrinho(id_usuario, p.getNome());
                if(quantidade > produtos.size()){
                    JOptionPane.showMessageDialog(null, "Você possui apenas "+produtos.size()+" unidades do produto no carrinho");
                    return;
                }
                for(int i=0 ; i<quantidade ; i++){
                    produtos.get(i).setSituacao(EstadoProduto.ESTOQUE);
                    produtos.get(i).setId_foreign(new UsuarioDAO().getIdGerente());
                    new ProdutoDAO().atualizarProduto(produtos.get(i));
                    modeloMainProdutos.addProduto(produtos.get(i), false);
                }
                if(quantidade == produtos.size()) modelo.removeProduto(p);
                else modelo.setValueAt(quantidadeOld-quantidade, index, 3);
                JOptionPane.showMessageDialog(null, "Unidades removidas do carrinho com sucesso!");
            } catch(SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
        }
        setTotal(cp_viewcarrinho_total, id_usuario, "");
        
    }//GEN-LAST:event_btn_viewcarrinho_removerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_viewcarrinho_continuar;
    private javax.swing.JButton btn_viewcarrinho_remover;
    private javax.swing.JLabel cp_viewcarrinho_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_viewcarrinho;
    // End of variables declaration//GEN-END:variables
}