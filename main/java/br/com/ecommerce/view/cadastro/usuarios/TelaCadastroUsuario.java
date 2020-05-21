/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.cadastro.usuarios;

import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.classes.Usuario;
import br.com.ecommerce.dao.UsuarioDAO;
import br.com.ecommerce.enumeracoes.TipoUsuario;
import br.com.ecommerce.expressao_regular.ValidaEmail;
import br.com.ecommerce.view.login.JPassWordFieldHint;
import br.com.ecommerce.view.login.JTextFieldHint;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author marco
 */
public class TelaCadastroUsuario extends PosicaoInternalFrame {

    /**
     * Creates new form TelaCadastroUsuario
     */
    
    private TipoUsuario tipo;
    
    public TelaCadastroUsuario(TipoUsuario tipo) {
        initComponents();
        setResizable(false);
        this.tipo = tipo;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        in_caduser_nome = new JTextFieldHint(new JTextField(), "", "Nome completo");
        in_caduser_cpf = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        in_caduser_email = new JTextFieldHint(new JTextField(), "", "E-mail válido");
        in_caduser_senha = new JPassWordFieldHint(new JPasswordField(), "" , "Senha. Máximo de 20 caracteres");
        in_caduser_senha2 = new JPassWordFieldHint(new JPasswordField(), "" , "Confirmação da senha");
        btn_caduser_enviar = new javax.swing.JButton();
        btn_caduser_cancelar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(18, 7, 67));

        jPanel2.setBackground(new java.awt.Color(18, 7, 80));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome completo");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CPF");

        in_caduser_nome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_caduser_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        in_caduser_cpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            in_caduser_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        in_caduser_cpf.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(in_caduser_nome)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(in_caduser_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_caduser_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_caduser_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(18, 7, 80));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados de acesso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("E-mail");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Senha");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirme a senha");

        in_caduser_email.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        in_caduser_senha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        in_caduser_senha2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(in_caduser_senha2)
                            .addComponent(in_caduser_email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16)
                        .addComponent(in_caduser_senha)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_caduser_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(in_caduser_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_caduser_senha2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btn_caduser_enviar.setBackground(new java.awt.Color(255, 255, 255));
        btn_caduser_enviar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_caduser_enviar.setText("Enviar");
        btn_caduser_enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_caduser_enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_caduser_enviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_caduser_enviarMouseExited(evt);
            }
        });
        btn_caduser_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_caduser_enviarActionPerformed(evt);
            }
        });

        btn_caduser_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_caduser_cancelar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_caduser_cancelar.setText("Cancelar");
        btn_caduser_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_caduser_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_caduser_cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_caduser_cancelarMouseExited(evt);
            }
        });
        btn_caduser_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_caduser_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btn_caduser_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_caduser_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_caduser_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_caduser_enviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
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

    private void btn_caduser_enviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_caduser_enviarMouseEntered
        btn_caduser_enviar.setBackground(Color.GREEN);
        btn_caduser_enviar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_caduser_enviarMouseEntered

    private void btn_caduser_enviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_caduser_enviarMouseExited
        btn_caduser_enviar.setBackground(Color.WHITE);
        btn_caduser_enviar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_caduser_enviarMouseExited

    private void btn_caduser_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_caduser_cancelarMouseEntered
        btn_caduser_cancelar.setBackground(Color.RED);
        btn_caduser_cancelar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_caduser_cancelarMouseEntered

    private void btn_caduser_cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_caduser_cancelarMouseExited
        btn_caduser_cancelar.setBackground(Color.WHITE);
        btn_caduser_cancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_caduser_cancelarMouseExited

    private void btn_caduser_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_caduser_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_caduser_cancelarActionPerformed

    private void btn_caduser_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_caduser_enviarActionPerformed
        
        String nome = in_caduser_nome.getText();
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, informe um nome");
            return;
        }
        
        String cpf = in_caduser_cpf.getText();
        if(cpf.equals("   .   .   -  ") || cpf == null || cpf.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, informe um CPF");
            return;
        }
        
        String email = in_caduser_email.getText();
        if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, informe um e-mail");
            return;
        } else if(!ValidaEmail.emailValido(email)) {
            JOptionPane.showMessageDialog(null, "Por favor, informe um e-mail válido");
            return;
        }
        
        char[] senha = in_caduser_senha.getPassword();
        if(senha.length == 0){
            JOptionPane.showMessageDialog(null, "Por favor, informe uma senha");
            return;
        } else if (senha.length > 20) {
            JOptionPane.showMessageDialog(null, "Por favor, informe uma senha com no máximo 20 caracteres");
            return;
        }
        
        char[] senha2 = in_caduser_senha2.getPassword();
        if(senha2.length == 0){
            JOptionPane.showMessageDialog(null, "Por favor, informe a senha novamente para confirmação");
            return;
        }
        
        int count = 0;
        if(senha2.length == senha.length) 
            for(int i=0 ; i<senha.length ; i++) if(senha[i] == senha2[i]) count++;
        if(count != senha.length) {
            JOptionPane.showMessageDialog(null, "As senhas não são iguais ...");
            return;
        }
        
        Usuario gravar = new Usuario(nome, cpf, email, tipo);
        gravar.setPassword(new StringBuilder().append(senha).toString());
        UsuarioDAO uD = new UsuarioDAO();
        try {
            uD.addUsuario(gravar);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            dispose();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no bando de dados");
        }
            
    }//GEN-LAST:event_btn_caduser_enviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_caduser_cancelar;
    private javax.swing.JButton btn_caduser_enviar;
    private javax.swing.JFormattedTextField in_caduser_cpf;
    private javax.swing.JTextField in_caduser_email;
    private javax.swing.JTextField in_caduser_nome;
    private javax.swing.JPasswordField in_caduser_senha;
    private javax.swing.JPasswordField in_caduser_senha2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}