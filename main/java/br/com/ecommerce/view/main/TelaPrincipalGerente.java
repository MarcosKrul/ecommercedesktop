/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.main;

import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.classes.Produto;
import br.com.ecommerce.classes.CarregaDadosModeloGerente;
import br.com.ecommerce.classes.Usuario;
import br.com.ecommerce.dao.FiltroDAO;
import br.com.ecommerce.enumeracoes.EstadoProduto;
import br.com.ecommerce.tables.ModeloMainGerente;
import br.com.ecommerce.view.att.produto.TelaAtualizarProduto;
import br.com.ecommerce.view.TelaTabelaSelecionar;
import br.com.ecommerce.view.TelaUnicoOuTodos;
import br.com.ecommerce.view.att.usuarios.TelaAtualizarDadosAcesso;
import br.com.ecommerce.view.att.usuarios.TelaAtualizarDadosPessoais;
import br.com.ecommerce.view.cadastro.produtos.TelaCadastroProduto;
import br.com.ecommerce.view.delete.produto.TelaDeletarProduto;
import br.com.ecommerce.view.delete.usuario.TelaDeletarUsuario;
import br.com.ecommerce.view.estoque.TelaAlterarEstoque;
import br.com.ecommerce.view.estoque.TelaLimparEstoque;
import br.com.ecommerce.view.info.TelaInformacoesGerente1;
import br.com.ecommerce.view.login.JTextFieldHint;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author marco
 */
public final class TelaPrincipalGerente extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalGerente
     */
    private Usuario usuario;
    private ModeloMainGerente modelo;
    
    public TelaPrincipalGerente(Usuario u) {
        initialize();
        this.usuario = u;
    }
    
    public TelaPrincipalGerente() {
        initialize();
    }
    
    private void initialize() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        modelo = new ModeloMainGerente();
        tabela_maingerente.setModel(modelo);
        new Thread(new CarregaDadosModeloGerente(modelo)).start();
        eventComboCategoria();
        eventComboSituacao();
        radioButtonAction(radiobuttom_maingerente_preco, 1);
        radioButtonAction(radiobuttom_maingerente_nome, 2);
        setCategoriasCombo();
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    private void limparRadioButton() {
        buttonGroup1.clearSelection();
    }
    
    public void setCategoriasCombo(){
        List<String> categorias = null;
        try {
            categorias = new FiltroDAO().getCategorias();
        } catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        if(categorias != null) for(String aux: categorias) combobox_maingerente_categoria.addItem(aux);
    }
    
    private void eventComboCategoria() {
        combobox_maingerente_categoria.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String selecionado = (String) combobox_maingerente_categoria.getSelectedItem();
                    if(selecionado.equals("Selecione")) new Thread(new CarregaDadosModeloGerente(modelo)).start();
                    else {
                        limparRadioButton();
                        in_maingerente_nome.setText("");
                        combobox_maingerente_situacao.setSelectedItem("Selecione");
                        List<Produto> list = null;
                        try {
                            list = new FiltroDAO().separaPorCategoria(selecionado);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
                        }
                        if(list == null) {
                            JOptionPane.showMessageDialog(null, "Nenhum produto disponível nesta categoria");
                            combobox_maingerente_categoria.setSelectedItem("Selecione");
                            new Thread(new CarregaDadosModeloGerente(modelo)).start();
                            return;
                        }
                        modelo.setDados(list);
                    }
                }
            }
        });
    }
    
    private void eventComboSituacao() {
        combobox_maingerente_situacao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    String selecionado = (String) combobox_maingerente_situacao.getSelectedItem();
                    if(selecionado.equals("Selecione")) new Thread(new CarregaDadosModeloGerente(modelo)).start();
                    else {
                        limparRadioButton();
                        in_maingerente_nome.setText("");
                        combobox_maingerente_categoria.setSelectedItem("Selecione");
                        EstadoProduto estado = null;
                        switch(selecionado){
                            case "Em estoque": estado = EstadoProduto.ESTOQUE; break;
                            case "Indisponível": estado = EstadoProduto.INDISPONIVEL; break;
                            case "Vendido": estado = EstadoProduto.VENDIDO; break;
                        }
                        List<Produto> list = null;
                        try {
                            list = new FiltroDAO().separaPorSituacao(estado);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
                        }
                        if(list == null) {
                            JOptionPane.showMessageDialog(null, "Nenhum produto corresponde a esta pesquisa");
                            combobox_maingerente_situacao.setSelectedItem("Selecione");
                            new Thread(new CarregaDadosModeloGerente(modelo)).start();
                            return;
                        }
                        modelo.setDados(list);
                    }
                }
            }
        });
    }
    
    private void radioButtonAction(JRadioButton rb, Integer diferenciar){
        rb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Produto> list = null;
                try {
                    if(diferenciar == 1) list = new FiltroDAO().ordenaPorPreco();
                    else list = new FiltroDAO().ordenaPorNome();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
                }
                if(list == null) {
                    JOptionPane.showMessageDialog(null, "Nenhum produto corresponde a esta pesquisa");
                    new Thread(new CarregaDadosModeloGerente(modelo)).start();
                    return;
                }
                modelo.setDados(list);
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

        jMenuItem9 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_maingerente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combobox_maingerente_situacao = new javax.swing.JComboBox<>();
        combobox_maingerente_categoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        in_maingerente_nome = new JTextFieldHint(new JTextField(), "", "Nome para busca");
        btn_maingerente_buscar = new javax.swing.JButton();
        btn_maingerente_atualizar = new javax.swing.JButton();
        btn_maingerente_deletar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        radiobuttom_maingerente_preco = new javax.swing.JRadioButton();
        radiobuttom_maingerente_nome = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(79, 79, 79));

        tabela_maingerente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabela_maingerente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabela_maingerente);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Categoria");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Situação");

        combobox_maingerente_situacao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        combobox_maingerente_situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Em estoque", "Indisponível", "Vendido" }));

        combobox_maingerente_categoria.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        combobox_maingerente_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome");

        in_maingerente_nome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        in_maingerente_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_maingerente_buscar.setBackground(new java.awt.Color(153, 153, 153));
        btn_maingerente_buscar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_maingerente_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_maingerente_buscar.setText("Buscar");
        btn_maingerente_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_maingerente_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_maingerente_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_maingerente_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_maingerente_buscarMouseExited(evt);
            }
        });
        btn_maingerente_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maingerente_buscarActionPerformed(evt);
            }
        });

        btn_maingerente_atualizar.setBackground(new java.awt.Color(153, 153, 153));
        btn_maingerente_atualizar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_maingerente_atualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_maingerente_atualizar.setText("Atualizar");
        btn_maingerente_atualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_maingerente_atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_maingerente_atualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_maingerente_atualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_maingerente_atualizarMouseExited(evt);
            }
        });
        btn_maingerente_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maingerente_atualizarActionPerformed(evt);
            }
        });

        btn_maingerente_deletar.setBackground(new java.awt.Color(153, 153, 153));
        btn_maingerente_deletar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_maingerente_deletar.setForeground(new java.awt.Color(255, 255, 255));
        btn_maingerente_deletar.setText("Excluir");
        btn_maingerente_deletar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_maingerente_deletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_maingerente_deletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_maingerente_deletarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_maingerente_deletarMouseExited(evt);
            }
        });
        btn_maingerente_deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maingerente_deletarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ordenar por:");

        radiobuttom_maingerente_preco.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(radiobuttom_maingerente_preco);
        radiobuttom_maingerente_preco.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        radiobuttom_maingerente_preco.setForeground(new java.awt.Color(51, 51, 51));
        radiobuttom_maingerente_preco.setText("Preço");

        radiobuttom_maingerente_nome.setBackground(new java.awt.Color(153, 153, 153));
        buttonGroup1.add(radiobuttom_maingerente_nome);
        radiobuttom_maingerente_nome.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        radiobuttom_maingerente_nome.setText("Nome");

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
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combobox_maingerente_categoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combobox_maingerente_situacao, 0, 170, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(in_maingerente_nome))
                            .addComponent(btn_maingerente_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radiobuttom_maingerente_preco)
                                .addGap(11, 11, 11)
                                .addComponent(radiobuttom_maingerente_nome))
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_maingerente_atualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(btn_maingerente_deletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(in_maingerente_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(combobox_maingerente_situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(btn_maingerente_atualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_maingerente_deletar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radiobuttom_maingerente_preco)
                        .addComponent(radiobuttom_maingerente_nome))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_maingerente_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(combobox_maingerente_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Usuario");

        jMenuItem3.setText("Atualizar dados pessoais");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Atualizar dados de acesso");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenu1.add(jSeparator2);

        jMenuItem5.setText("Deletar conta");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Produto");

        jMenuItem6.setText("Novo produto");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Atualizar dados de produto");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);
        jMenu2.add(jSeparator4);

        jMenuItem8.setText("Deletar produto");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Estoque");

        jMenuItem10.setText("Alterar estoque");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem12.setText("Limpar estoque");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Informações");

        jMenuItem1.setText("Visualizar informações");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Registro de compras");

        jMenuItem11.setText("Gerar relatório");
        jMenu4.add(jMenuItem11);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TelaAtualizarDadosPessoais tela = new TelaAtualizarDadosPessoais(usuario);
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TelaAtualizarDadosAcesso tela = new TelaAtualizarDadosAcesso(usuario);
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TelaDeletarUsuario tela = new TelaDeletarUsuario(usuario.getId());
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        TelaCadastroProduto tela = new TelaCadastroProduto(usuario.getId(), modelo);
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        TelaTabelaSelecionar tela = new TelaTabelaSelecionar(modelo, "Atualizar", 1);
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }//GEN-LAST:event_jMenuItem7ActionPerformed
	
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        TelaTabelaSelecionar tela = new TelaTabelaSelecionar(modelo, "Excluir", 2);
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }//GEN-LAST:event_jMenuItem8ActionPerformed
	
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        TelaAlterarEstoque tela = new TelaAlterarEstoque(modelo);
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }                                            

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        TelaLimparEstoque tela = new TelaLimparEstoque(modelo);
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }      

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        TelaInformacoesGerente1 tela = new TelaInformacoesGerente1(jDesktopPane1);
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
    }//GEN-LAST:event_jMenuItem1ActionPerformed	

    private void btn_maingerente_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maingerente_buscarMouseEntered
        btn_maingerente_buscar.setForeground(Color.BLACK);
        btn_maingerente_buscar.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_maingerente_buscarMouseEntered

    private void btn_maingerente_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maingerente_buscarMouseExited
        btn_maingerente_buscar.setForeground(Color.WHITE);
        btn_maingerente_buscar.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btn_maingerente_buscarMouseExited

    private void btn_maingerente_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_maingerente_buscarActionPerformed
        
        String nomeBusca = in_maingerente_nome.getText();
        if(nomeBusca.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, informe um nome");
            return;
        }
        
        List<Produto> list = null;
        try {
            list = new FiltroDAO().buscarNome(nomeBusca);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        if(list == null) {
            JOptionPane.showMessageDialog(null, "Nenhum produto corresponde a esta pesquisa");
            new Thread(new CarregaDadosModeloGerente(modelo)).start();
            return;
        }
        modelo.setDados(list);
        limparRadioButton();
        combobox_maingerente_categoria.setSelectedItem("Selecione");
        combobox_maingerente_situacao.setSelectedItem("Selecione");
        
    }//GEN-LAST:event_btn_maingerente_buscarActionPerformed

    private void btn_maingerente_atualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maingerente_atualizarMouseEntered
        btn_maingerente_atualizar.setForeground(Color.BLACK);
        btn_maingerente_atualizar.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_maingerente_atualizarMouseEntered

    private void btn_maingerente_atualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maingerente_atualizarMouseExited
        btn_maingerente_atualizar.setForeground(Color.WHITE);
        btn_maingerente_atualizar.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btn_maingerente_atualizarMouseExited

    private void btn_maingerente_deletarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maingerente_deletarMouseEntered
        btn_maingerente_deletar.setForeground(Color.BLACK);
        btn_maingerente_deletar.setBackground(Color.WHITE);
    }//GEN-LAST:event_btn_maingerente_deletarMouseEntered

    private void btn_maingerente_deletarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_maingerente_deletarMouseExited
        btn_maingerente_deletar.setForeground(Color.WHITE);
        btn_maingerente_deletar.setBackground(new Color(153,153,153));
    }//GEN-LAST:event_btn_maingerente_deletarMouseExited

    private void btn_maingerente_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_maingerente_atualizarActionPerformed
       
        int index = tabela_maingerente.getSelectedRow();
        if(index == -1){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um produto na tabela");
            return;
        }
        
        PosicaoInternalFrame tela = null;
        if(modelo.quantidadeProduto(index) == 1)
            tela = new TelaAtualizarProduto(false, index, modelo); 
        else tela = new TelaUnicoOuTodos(index, 1, jDesktopPane1, modelo);
        
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
        tabela_maingerente.clearSelection();
        
    }//GEN-LAST:event_btn_maingerente_atualizarActionPerformed

    private void btn_maingerente_deletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_maingerente_deletarActionPerformed

        int index = tabela_maingerente.getSelectedRow();
        if(index == -1){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um produto na tabela");
            return;
        }
        
        Produto p = modelo.getProdutoIndex(index);
        if(p.getSituacao() == EstadoProduto.INDISPONIVEL || p.getSituacao() == EstadoProduto.VENDIDO){
            JOptionPane.showMessageDialog(null, "Não é possível excluir este produto");
            tabela_maingerente.clearSelection();
            return;
        }
        
        PosicaoInternalFrame tela = null;
        if(modelo.quantidadeProduto(index) == 1)
            tela = new TelaDeletarProduto(false, p, modelo); 
        else tela = new TelaUnicoOuTodos(index, 2, jDesktopPane1, modelo);
        
        jDesktopPane1.add(tela);
        tela.setVisible(true);
        tela.setPosicao();
        tabela_maingerente.clearSelection();
        
    }//GEN-LAST:event_btn_maingerente_deletarActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipalGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipalGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_maingerente_atualizar;
    private javax.swing.JButton btn_maingerente_buscar;
    private javax.swing.JButton btn_maingerente_deletar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combobox_maingerente_categoria;
    private javax.swing.JComboBox<String> combobox_maingerente_situacao;
    private javax.swing.JTextField in_maingerente_nome;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JRadioButton radiobuttom_maingerente_nome;
    private javax.swing.JRadioButton radiobuttom_maingerente_preco;
    private javax.swing.JTable tabela_maingerente;
    // End of variables declaration//GEN-END:variables
}
