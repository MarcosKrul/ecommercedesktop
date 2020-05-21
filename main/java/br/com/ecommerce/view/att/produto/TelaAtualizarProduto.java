/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.att.produto;

import br.com.ecommerce.classes.CarregaDadosModeloGerente;
import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.dao.FiltroDAO;
import br.com.ecommerce.dao.ProdutoDAO;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import br.com.ecommerce.tables.ModeloMainGerente;
import br.com.ecommerce.view.login.JTextFieldHint;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author marco
 */
public class TelaAtualizarProduto extends PosicaoInternalFrame {

    /**
     * Creates new form TelaAtualizarProduto
     */
    
    private final ModeloMainGerente MODELO;
    private final boolean TODOS;
    private final int INDEX;
    private final Produto OLD;
    
    public TelaAtualizarProduto(boolean todos, int index, ModeloMainGerente modelo) {
        initComponents();
        setResizable(false);
        this.INDEX = index;
        this.TODOS = todos;
        this.MODELO = modelo;
        OLD = MODELO.getProdutoIndex(index);
        comboListener();
        carregaItensCombo();
        setDadosInput();
        in_attproduto_outracategoria.setEnabled(false);
        if(OLD.getSituacao() == EstadoProduto.INDISPONIVEL && !todos){
            in_attproduto_preco.setBackground(new Color(211,211,211));
            in_attproduto_preco.setEnabled(false);
        }
    }
    
    private void setDadosInput() {
        Produto p = MODELO.getProdutoIndex(INDEX);
        in_attproduto_nome.setText(p.getNome());
        in_attproduto_descricao.setText(p.getDescricao());
        in_attproduto_preco.setText(p.getPreco().toString());
        combobox_attproduto_categoria.setSelectedItem(p.getCategoria());
    }
    
    private void carregaItensCombo(){
        List<String> list = null;
        try {
            list = new FiltroDAO().getCategorias();
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        if(list == null) return;
        for(String aux: list) combobox_attproduto_categoria.addItem(aux);
        combobox_attproduto_categoria.addItem("Outra");
    }
    
    private void comboListener() {
        combobox_attproduto_categoria.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String selecionado = (String) combobox_attproduto_categoria.getSelectedItem();
                    if(selecionado.equals("Outra")){
                        in_attproduto_outracategoria.setEnabled(true);
                        in_attproduto_outracategoria.setBackground(Color.WHITE);
                    } else {
                        in_attproduto_outracategoria.setEnabled(false);
                        in_attproduto_outracategoria.setText("");
                        in_attproduto_outracategoria.setBackground(new Color(211,211,211));
                    }
                }
            }
        });
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
        in_attproduto_nome = new JTextFieldHint(new JTextField(), "", "Nome do produto");
        in_attproduto_descricao = new JTextFieldHint(new JTextField(), "", "Descrição do produto");
        combobox_attproduto_categoria = new javax.swing.JComboBox<>();
        in_attproduto_outracategoria = new JTextFieldHint(new JTextField(), "", "Outra categoria");
        in_attproduto_preco = new JTextFieldHint(new JTextField(), "", "Valor do produto");
        btn_attproduto_enviar = new javax.swing.JButton();
        btn_attproduto_cancelar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(18, 7, 67));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descrição");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Categoria");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Preço");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Outra");

        in_attproduto_nome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_attproduto_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        in_attproduto_descricao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_attproduto_descricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        combobox_attproduto_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        in_attproduto_outracategoria.setBackground(new java.awt.Color(211, 211, 211));
        in_attproduto_outracategoria.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_attproduto_outracategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        in_attproduto_preco.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_attproduto_preco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_attproduto_enviar.setBackground(new java.awt.Color(255, 255, 255));
        btn_attproduto_enviar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_attproduto_enviar.setText("Enviar");
        btn_attproduto_enviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_attproduto_enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_attproduto_enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_attproduto_enviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_attproduto_enviarMouseExited(evt);
            }
        });
        btn_attproduto_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_attproduto_enviarActionPerformed(evt);
            }
        });

        btn_attproduto_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_attproduto_cancelar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_attproduto_cancelar.setText("Cancelar");
        btn_attproduto_cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_attproduto_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_attproduto_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_attproduto_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_attproduto_cancelarMouseExited(evt);
            }
        });
        btn_attproduto_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_attproduto_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(in_attproduto_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                            .addComponent(in_attproduto_descricao)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combobox_attproduto_categoria, 0, 175, Short.MAX_VALUE)
                            .addComponent(in_attproduto_preco))
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(in_attproduto_outracategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btn_attproduto_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btn_attproduto_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(in_attproduto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(in_attproduto_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(in_attproduto_outracategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_attproduto_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_attproduto_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_attproduto_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_attproduto_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
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

    private void btn_attproduto_enviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_attproduto_enviarMouseEntered
        btn_attproduto_enviar.setBackground(Color.GREEN);
        btn_attproduto_enviar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_attproduto_enviarMouseEntered

    private void btn_attproduto_enviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_attproduto_enviarMouseExited
        btn_attproduto_enviar.setBackground(Color.WHITE);
        btn_attproduto_enviar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_attproduto_enviarMouseExited

    private void btn_attproduto_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_attproduto_cancelarMouseEntered
        btn_attproduto_cancelar.setBackground(Color.RED);
        btn_attproduto_cancelar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_attproduto_cancelarMouseEntered

    private void btn_attproduto_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_attproduto_cancelarMouseExited
        btn_attproduto_cancelar.setBackground(Color.WHITE);
        btn_attproduto_cancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_attproduto_cancelarMouseExited

    private void btn_attproduto_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_attproduto_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_attproduto_cancelarActionPerformed

    private void btn_attproduto_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_attproduto_enviarActionPerformed
        
        String nome = in_attproduto_nome.getText();
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, informe um nome");
            return;
        }
        
        String descricao = in_attproduto_descricao.getText();
        
        String categoria = (String) combobox_attproduto_categoria.getSelectedItem();
        if(categoria.equals("Selecione")){
            JOptionPane.showMessageDialog(null, "Por favor, informe a categoria do produto");
            return;
        }
        if (categoria.equals("Outra")){
            String outra = in_attproduto_outracategoria.getText();
            if(outra.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, informe a categoria do produto");
                return;
            }
            categoria = outra;
        }
        
        String sPreco = in_attproduto_preco.getText();
        if(sPreco.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, informe o preço do produto");
            return;
        }
        Double preco = null;
        try {
            preco = Double.parseDouble(sPreco);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Por favor, informe um preço válido (apenas números)");
            return;
        }
        
        if(!TODOS){
            Produto p = new Produto(nome, descricao, categoria, preco);
            if(p.equals(OLD)){
                JOptionPane.showMessageDialog(null, "Não houve alteração nos dados");
                return;
            }
            p.setId_foreign(OLD.getId_foreign());
            p.setId_produto(OLD.getId_produto());
            p.setSituacao(OLD.getSituacao());
            try {
                new ProdutoDAO().atualizarProduto(p);
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
                MODELO.setProduto(INDEX, p);
                dispose();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
        } else {
            List<Produto> list = null;
            try {
                list = new ProdutoDAO().unidadesMesmoProduto(OLD.getNome(), OLD.getDescricao(), 
                        OLD.getCategoria(), OLD.getPreco());
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
            if(list != null) {
                for(Produto aux: list){
                    aux.setNome(nome);
                    aux.setDescricao(descricao);
                    aux.setCategoria(categoria);
                    if(aux.getSituacao() == EstadoProduto.ESTOQUE || aux.getSituacao() == EstadoProduto.FORA_ESTOQUE)
                        aux.setPreco(preco);
                    try{
                        new ProdutoDAO().atualizarProduto(aux);
                    } catch (SQLException e){
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
                    }
                }
                JOptionPane.showMessageDialog(null, "Produtos atualizados com sucesso!");
                new Thread(new CarregaDadosModeloGerente(MODELO)).start();
                dispose();
            }
        }
        
    }//GEN-LAST:event_btn_attproduto_enviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_attproduto_cancelar;
    private javax.swing.JButton btn_attproduto_enviar;
    private javax.swing.JComboBox<String> combobox_attproduto_categoria;
    private javax.swing.JTextField in_attproduto_descricao;
    private javax.swing.JTextField in_attproduto_nome;
    private javax.swing.JTextField in_attproduto_outracategoria;
    private javax.swing.JTextField in_attproduto_preco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}