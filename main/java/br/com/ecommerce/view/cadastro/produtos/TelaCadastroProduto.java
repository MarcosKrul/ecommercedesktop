/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.cadastro.produtos;

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
public class TelaCadastroProduto extends PosicaoInternalFrame {

    /**
     * Creates new form TelaCadastroProduto
     */
    
    private final Integer ID_GERENTE;
    private final ModeloMainGerente MODELO;
    
    public TelaCadastroProduto(Integer id, ModeloMainGerente modelo) {
        initComponents();
        this.ID_GERENTE = id;
        this.MODELO = modelo;
        in_cadproduto_outracategoria.setEnabled(false);
        in_cadproduto_quantidade.setEnabled(false);
        comboListenerCategoria();
        comboListenerSituacao();
        List<String> categorias = null;
        try {
            categorias = new FiltroDAO().getCategorias();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        if(categorias != null) for(String aux : categorias) combobox_cadproduto_categoria.addItem(aux);
        combobox_cadproduto_categoria.addItem("Outra");
    }
    
    private void comboListenerCategoria() {
        combobox_cadproduto_categoria.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String selecionado = (String) combobox_cadproduto_categoria.getSelectedItem();
                    if(selecionado.equals("Outra")){
                        in_cadproduto_outracategoria.setEnabled(true);
                        in_cadproduto_outracategoria.setBackground(Color.WHITE);
                    } else{
                        in_cadproduto_outracategoria.setBackground(new Color(211,211,211));
                        in_cadproduto_outracategoria.setEnabled(false);
                    }
                }
            }
        });
    }

    private void comboListenerSituacao() {
        combobox_cadproduto_situacao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String selecionado = (String) combobox_cadproduto_situacao.getSelectedItem();
                    if(selecionado.equals("Em estoque")){
                        in_cadproduto_quantidade.setEnabled(true);
                        in_cadproduto_quantidade.setBackground(Color.WHITE);
                    } else {
                        in_cadproduto_quantidade.setEnabled(false);
                        in_cadproduto_quantidade.setBackground(new Color(211,211,211));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        in_cadproduto_nome = new JTextFieldHint(new JTextField(), "", "Nome do produto");
        in_cadproduto_descricao = new JTextFieldHint(new JTextField(), "", "Descrição do produto");
        combobox_cadproduto_categoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        in_cadproduto_outracategoria = new JTextFieldHint(new JTextField(), "", "Outra categoria");
        combobox_cadproduto_situacao = new javax.swing.JComboBox<>();
        in_cadproduto_quantidade = new JTextFieldHint(new JTextField(), "", "Quantidade em estoque");
        in_cadproduto_preco = new JTextFieldHint(new JTextField(), "", "Valor do produto");
        jLabel4 = new javax.swing.JLabel();
        btn_cadproduto_enviar = new javax.swing.JButton();
        btn_cadproduto_cancelar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(18, 7, 67));

        jPanel2.setBackground(new java.awt.Color(18, 7, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descrição");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Categoria");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Situação");

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantidade");

        in_cadproduto_nome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_cadproduto_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        in_cadproduto_descricao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_cadproduto_descricao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        combobox_cadproduto_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Outra");

        in_cadproduto_outracategoria.setBackground(new java.awt.Color(211, 211, 211));
        in_cadproduto_outracategoria.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_cadproduto_outracategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        combobox_cadproduto_situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Em estoque", "Fora de estoque" }));

        in_cadproduto_quantidade.setBackground(new java.awt.Color(211, 211, 211));
        in_cadproduto_quantidade.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_cadproduto_quantidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        in_cadproduto_preco.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_cadproduto_preco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Preço");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(in_cadproduto_nome))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(in_cadproduto_descricao)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(combobox_cadproduto_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(in_cadproduto_outracategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combobox_cadproduto_situacao, 0, 170, Short.MAX_VALUE)
                            .addComponent(in_cadproduto_preco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(in_cadproduto_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_cadproduto_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(in_cadproduto_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel3)
                        .addComponent(in_cadproduto_outracategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combobox_cadproduto_categoria, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(combobox_cadproduto_situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(in_cadproduto_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_cadproduto_preco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31))
        );

        btn_cadproduto_enviar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadproduto_enviar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_cadproduto_enviar.setText("Enviar");
        btn_cadproduto_enviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_cadproduto_enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cadproduto_enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cadproduto_enviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cadproduto_enviarMouseExited(evt);
            }
        });
        btn_cadproduto_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadproduto_enviarActionPerformed(evt);
            }
        });

        btn_cadproduto_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cadproduto_cancelar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_cadproduto_cancelar.setText("Cancelar");
        btn_cadproduto_cancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_cadproduto_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cadproduto_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cadproduto_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cadproduto_cancelarMouseExited(evt);
            }
        });
        btn_cadproduto_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadproduto_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btn_cadproduto_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(btn_cadproduto_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cadproduto_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cadproduto_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void btn_cadproduto_enviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadproduto_enviarMouseEntered
        btn_cadproduto_enviar.setBackground(Color.GREEN);
        btn_cadproduto_enviar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_cadproduto_enviarMouseEntered

    private void btn_cadproduto_enviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadproduto_enviarMouseExited
        btn_cadproduto_enviar.setBackground(Color.WHITE);
        btn_cadproduto_enviar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_cadproduto_enviarMouseExited

    private void btn_cadproduto_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadproduto_cancelarMouseEntered
        btn_cadproduto_cancelar.setBackground(Color.RED);
        btn_cadproduto_cancelar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_cadproduto_cancelarMouseEntered

    private void btn_cadproduto_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadproduto_cancelarMouseExited
        btn_cadproduto_cancelar.setBackground(Color.WHITE);
        btn_cadproduto_cancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_cadproduto_cancelarMouseExited

    private void btn_cadproduto_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadproduto_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cadproduto_cancelarActionPerformed

    private void btn_cadproduto_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadproduto_enviarActionPerformed
            
        String nome = in_cadproduto_nome.getText();
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, informe o nome do produto");
            return;
        }
        
        String descricao = in_cadproduto_descricao.getText();
        
        String categoria = (String) combobox_cadproduto_categoria.getSelectedItem();
        if(categoria.equals("Selecione")){
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma categoria");
            return;
        }
        if(categoria.equals("Outra")){
            String outra = in_cadproduto_outracategoria.getText();
            if(outra.equals("")){
                JOptionPane.showMessageDialog(null, "Por favor, informe a categoria");
                return;
            }
            categoria = outra;
        }
        
        String situacao = (String) combobox_cadproduto_situacao.getSelectedItem();
        if(situacao.equals("Selecione")){
            JOptionPane.showMessageDialog(null, "Por favor, informe a situação do produto");
            return;
        }
                
        Double preco;
        try {
            preco = Double.parseDouble(in_cadproduto_preco.getText());
        } catch (NumberFormatException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Por favor, informe um preço válido (apenas números)");
            return;
        }
        
        Produto p = new Produto(nome, descricao, categoria, preco);
        p.setId_foreign(ID_GERENTE);
        
        int quantidade = 1;
        if(situacao.equals("Em estoque")) {
            p.setSituacao(EstadoProduto.ESTOQUE);
            try{
                quantidade = Integer.parseInt(in_cadproduto_quantidade.getText());
            } catch (NumberFormatException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Por favor, informe uma quantidade válida");
                return;
            }
        } else if(situacao.equals("Fora de estoque")) p.setSituacao(EstadoProduto.FORA_ESTOQUE);
        
        for(int i=0 ; i<quantidade ; i++){
            try {
                new ProdutoDAO().addProduto(p);
                if(i==0){
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
                    new Thread(new CarregaDadosModeloGerente(MODELO)).start();
                    dispose();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
            }
        }
        
    }//GEN-LAST:event_btn_cadproduto_enviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadproduto_cancelar;
    private javax.swing.JButton btn_cadproduto_enviar;
    private javax.swing.JComboBox<String> combobox_cadproduto_categoria;
    private javax.swing.JComboBox<String> combobox_cadproduto_situacao;
    private javax.swing.JTextField in_cadproduto_descricao;
    private javax.swing.JTextField in_cadproduto_nome;
    private javax.swing.JTextField in_cadproduto_outracategoria;
    private javax.swing.JTextField in_cadproduto_preco;
    private javax.swing.JTextField in_cadproduto_quantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
