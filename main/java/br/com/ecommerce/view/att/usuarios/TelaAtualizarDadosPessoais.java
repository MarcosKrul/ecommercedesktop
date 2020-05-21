/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.view.att.usuarios;

import br.com.ecommerce.classes.PosicaoInternalFrame;
import br.com.ecommerce.classes.Usuario;
import br.com.ecommerce.dao.UsuarioDAO;
import br.com.ecommerce.enumeracoes.TipoUsuario;
import br.com.ecommerce.view.login.JTextFieldHint;
import br.com.ecommerce.view.main.TelaPrincipalGerente;
import br.com.ecommerce.view.main.TelaPrincipalUsuario;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author marco
 */
public class TelaAtualizarDadosPessoais extends PosicaoInternalFrame {

    /**
     * Creates new form TelaAtualizarDadosPessoais
     */
    private Usuario user;
    
    public TelaAtualizarDadosPessoais(Usuario u) {
        initComponents();
        setResizable(false);
        this.user = u;
        in_attpessoais_nome.setText(user.getNome());
        in_attpessoais_cpf.setText(user.getCpf());
    }
    
    public Usuario getUsuario() {
        return user;
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
        in_attpessoais_nome = new JTextFieldHint(new JTextField(), "", "Nome completo");
        in_attpessoais_cpf = new javax.swing.JFormattedTextField();
        btn_attpessoais_enviar = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(18, 7, 67));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CPF");

        in_attpessoais_nome.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        in_attpessoais_nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        in_attpessoais_cpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            in_attpessoais_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        in_attpessoais_cpf.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N

        btn_attpessoais_enviar.setBackground(new java.awt.Color(255, 255, 255));
        btn_attpessoais_enviar.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_attpessoais_enviar.setText("Enviar");
        btn_attpessoais_enviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_attpessoais_enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_attpessoais_enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_attpessoais_enviarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_attpessoais_enviarMouseExited(evt);
            }
        });
        btn_attpessoais_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_attpessoais_enviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(in_attpessoais_nome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(in_attpessoais_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btn_attpessoais_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(in_attpessoais_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(in_attpessoais_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addComponent(btn_attpessoais_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
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

    private void btn_attpessoais_enviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_attpessoais_enviarMouseEntered
        btn_attpessoais_enviar.setBackground(Color.GREEN);
        btn_attpessoais_enviar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btn_attpessoais_enviarMouseEntered

    private void btn_attpessoais_enviarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_attpessoais_enviarMouseExited
        btn_attpessoais_enviar.setBackground(Color.WHITE);
        btn_attpessoais_enviar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btn_attpessoais_enviarMouseExited

    private void btn_attpessoais_enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_attpessoais_enviarActionPerformed
        
        String nome = in_attpessoais_nome.getText();
        if(nome.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor, informe um nome");
            return;
        }
        
        String cpf = in_attpessoais_cpf.getText();
        if(cpf.equals("") || cpf.equals("   .   .   -  ") || cpf == null){
            JOptionPane.showMessageDialog(null, "Por favor, informe um CPF");
            return;
        }
        
        if(cpf.equals(user.getCpf()) && nome.equals(user.getNome())){
            JOptionPane.showMessageDialog(null, "Não houve alteração nos dados");
            dispose();
            return;
        }
        
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar os dados?", 
                "Confirmação de alteração", JOptionPane.YES_NO_OPTION);
        
        if(resposta == JOptionPane.NO_OPTION) return;
        
        user.setNome(nome);
        user.setCpf(cpf);
        
        try {
            UsuarioDAO uD = new UsuarioDAO();
            uD.atualizarUsuario(user);
            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
            if(user.getTipo() == TipoUsuario.USUARIO_CONSUMIDOR)
                new TelaPrincipalUsuario().setUsuario(user);
            else new TelaPrincipalGerente().setUsuario(user);
            dispose();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro no banco de dados");
        }
        
    }//GEN-LAST:event_btn_attpessoais_enviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_attpessoais_enviar;
    private javax.swing.JFormattedTextField in_attpessoais_cpf;
    private javax.swing.JTextField in_attpessoais_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
