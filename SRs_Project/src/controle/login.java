//Declaração de pacote:
package controle;

//Importação de classes:
import admin.frm_menu_admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexao.Conexao;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import porteiro.frm_menu_porteiro;

/**
 *
 * @author Júlio, Maria e Victor
 */

//Classe login, com herdando caracterísitcas/métodos da classe JFrame:
public class login extends javax.swing.JFrame {
    
    //Objeto com atributos da classe Connection. Finalidade: Ligação com Banco de Dados.
    Connection con = null;
    
    //Objeto com atributos da classe ResultSet. Finalidade: Procura dos registros do banco.
    ResultSet rs = null;
    
    /*Objeto com atributos da classe PreparedStatement. 
    Finalidade: Adicionar os dados inseridos pelo usuário na busca de dados do banco.*/
    PreparedStatement ps = null;
    
    
    /**
     * Criando o novo formulário login:
     */
    public login() {
        initComponents();        
        con = Conexao.conecta();
        logo();
        perfil();
        pass();
        setLocationRelativeTo(null);
    }

    /**
    * Esse método é chamado dentro do construtor para iniciar o form, sendo gerado
    * e atualizado automaticamente pelo próprio sistema do form
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblPass = new javax.swing.JLabel();
        tfNumAcesso = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fundo.setBackground(new java.awt.Color(11, 25, 49));

        btnLogin.setBackground(new java.awt.Color(51, 121, 241));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 121, 241));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(51, 121, 241));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPass)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        tfNumAcesso.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfNumAcesso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNumAcessoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumAcessoKeyTyped(evt);
            }
        });

        tfSenha.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tfSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout fundoLayout = new javax.swing.GroupLayout(fundo);
        fundo.setLayout(fundoLayout);
        fundoLayout.setHorizontalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fundoLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 164, Short.MAX_VALUE))
            .addGroup(fundoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNumAcesso)
                    .addComponent(tfSenha))
                .addGap(42, 42, 42))
        );
        fundoLayout.setVerticalGroup(
            fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNumAcesso))
                .addGap(31, 31, 31)
                .addGroup(fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSenha)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addComponent(btnLogin)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método "ActionPerformed" do botão de login. Finalidade: verificar se a inserção dos campos está correta para realizar o login no sistema
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        //Armazenando os valores dos campos "número de acesso" e "senha" em atributos:
        String numacess = tfNumAcesso.getText();
        String senha = tfSenha.getText();

        //Verificando se o usuário inseriu algo nos campos solicitados:
        if (numacess.length() > 0 && senha.length() > 0) {
            //Verificando se a senha possui ao menos 8 digitos:
            if (senha.length() >= 8) {
                
                int num_acesso = Integer.parseInt(numacess);
                
                //Procurando dados inseridos no banco de dados
                try {
                    //Comando SQL:
                    String pesquisa = "SELECT * FROM usuario WHERE num_acesso=? AND senha=?";
                    
                    /*Comando que "prepara" declaração para busca no banco, onde os dados 
                    inseridos serão colocados no lugar do '?' de cada campo do select*/
                    ps = con.prepareStatement(pesquisa);

                    //Adicionando os dados inseridos nos parâmetros:
                    ps.setInt(1, num_acesso);
                    ps.setString(2, senha);

                    //Execução da busca:
                    rs = ps.executeQuery();

                    //Validando se o dado inserido é verdadeiro ou não:
                    if (rs.next()) {
                        /*Chamando alguns atributos da tabela do banco para a
                        passagem de parâmetro e indo para a tela inicial do admin:*/
                        int realId = rs.getInt("id_usuario");
                        int realUser = rs.getInt("num_acesso");
                        
                        /*Chamando alguns atributos da tabela do banco para a 
                        validação da realização do login*/
                        String realPerm = rs.getString("permissao");
                        String realSit = rs.getString("situacao");

                        //Verificando se a conta do usuário está ativa ou não
                        if ("ativo".equals(realSit)) {
                            //Verificando se o usuário é um administrador ou um porteiro: 
                            if ("admin".equals(realPerm)) {
                                //Acessando a interface de menu do administrador:
                                frm_menu_admin mostra = new frm_menu_admin(realId, realUser);
                                mostra.setVisible(true);
                                dispose();
                            } else {
                                //Acessando a interface de menu do porteiro:
                                frm_menu_porteiro mostra = new frm_menu_porteiro(realId, realUser);
                                mostra.setVisible(true);
                                dispose();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "\n Conta inativada!\n Por favor entre em contato com a empresa para mais informações.", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                            tfNumAcesso.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "\n Número de acesso e/ou senha estão incorretos!\n Tente novamente", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                        tfNumAcesso.requestFocus();
                    }

                    // Fechando o ResultSet e o PreparedStatement após sua utilização
                    rs.close();
                    ps.close();

                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar esses dados inseridos...\n ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    tfNumAcesso.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "\n Número de acesso e/ou senha estão incorretos!\n Por favor, tente novamente.", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                tfNumAcesso.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "O campo de Número de acesso e/ou Senha estão vazios. \nPor favor, verifique e preencha os dados novamente!");
            tfNumAcesso.requestFocus();
        }


    }//GEN-LAST:event_btnLoginActionPerformed

    private void tfNumAcessoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumAcessoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            tfSenha.requestFocus();
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            tfSenha.requestFocus();
        }
        
    }//GEN-LAST:event_tfNumAcessoKeyPressed

    private void tfSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnLogin.doClick();
        }
        if(evt.getKeyCode() == KeyEvent.VK_UP){
            tfNumAcesso.requestFocus();
        }
    }//GEN-LAST:event_tfSenhaKeyPressed

    private void tfNumAcessoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumAcessoKeyTyped
        String caracteres = "0123456789";
        
        if(!caracteres.contains(evt.getKeyChar() + "")){
            evt.consume();
        }
    }//GEN-LAST:event_tfNumAcessoKeyTyped

    //Método "logo", que define a imagem, e suas propriedades na tela:
    private void logo(){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo/SRs.png"));
        Image scaleImage = imageIcon.getImage().getScaledInstance(150, 150,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(scaleImage);
        lblLogo.setIcon(img);
    }
        
    //Método "perfil", que define a imagem, que funciona para referenciar o ícone do "perfil":
    private void perfil(){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo/perfil.png"));
        Image scaleImage = imageIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(scaleImage);
        jLabel1.setIcon(img);
    }
    
    //Método "pass", que define a imagem, que funciona para referenciar o ícone da "senha":    
    private void pass(){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo/pass.png"));
        Image scaleImage = imageIcon.getImage().getScaledInstance(30, 28,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(scaleImage);
        lblPass.setIcon(img);
    }
        
    
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Criação e apresentação do form: */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel fundo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPass;
    private javax.swing.JTextField tfNumAcesso;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables
}
