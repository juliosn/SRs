//Declaração de pacote:
package admin;

//Importação de classes:
import conexao.Conexao;
import controle.login;
import java.awt.Image;
import java.sql.Connection;
import javax.swing.ImageIcon;

/**
 *
 * @author Júlio, Maria e Victor
 */

//Classe frm_menu_admin, com herdando caracterísitcas/métodos da classe JFrame:
public class frm_menu_admin extends javax.swing.JFrame {

    //Objeto com atributos da classe Connection. Finalidade: Ligação com Banco de Dados.
    Connection con = null;
    
    //Objeto com atributos da classe login. Finalidade: Validação de login do usuário.
    login login;
    
    //Atributos utilizados para passagem de parâmetro e comparação de dados:
    private int id;
    private int usuario;
    
    /**
     * Criando o novo formulário frm_menu_admin:
     */
    public frm_menu_admin(int realId, int realUser) {
        initComponents();
        initVars(realId, realUser);
        con = Conexao.conecta();
        login = new login();
        logo();
    }

    //Método initVars() responsável por passar parâmetros de dados do usuário e
    //adicioná-los em atributos locais (da classe):
    private void initVars(int realId, int realUser)
    {
        id = realId;
        usuario = realUser;
    }

    
    /**
    * Esse método é chamado dentro do construtor para iniciar o form, sendo gerado
    * e atualizado automaticamente pelo próprio sistema do form
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back1 = new javax.swing.JPanel();
        back2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        btn_exit = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        back3 = new javax.swing.JPanel();
        btn_Geren_Cond = new javax.swing.JButton();
        btn_Gerenc_Port = new javax.swing.JButton();
        btn_Cond_In = new javax.swing.JButton();
        btn_Port_In = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back1.setBackground(new java.awt.Color(11, 25, 49));

        back2.setBackground(new java.awt.Color(11, 25, 49));

        btn_exit.setBackground(new java.awt.Color(51, 121, 241));
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/exit.png"))); // NOI18N
        btn_exit.setToolTipText("");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_home.setBackground(new java.awt.Color(51, 121, 241));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/home.png"))); // NOI18N
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout back2Layout = new javax.swing.GroupLayout(back2);
        back2.setLayout(back2Layout);
        back2Layout.setHorizontalGroup(
            back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 856, Short.MAX_VALUE)
                .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        back2Layout.setVerticalGroup(
            back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addGroup(back2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        back3.setBackground(new java.awt.Color(212, 223, 253));

        javax.swing.GroupLayout back3Layout = new javax.swing.GroupLayout(back3);
        back3.setLayout(back3Layout);
        back3Layout.setHorizontalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 973, Short.MAX_VALUE)
        );
        back3Layout.setVerticalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );

        btn_Geren_Cond.setBackground(new java.awt.Color(51, 121, 241));
        btn_Geren_Cond.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Geren_Cond.setForeground(new java.awt.Color(255, 255, 255));
        btn_Geren_Cond.setText("<html>   <center>   Gerenciamento <br/> de Condomínios  </center>  </html>");
        btn_Geren_Cond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Geren_CondActionPerformed(evt);
            }
        });

        btn_Gerenc_Port.setBackground(new java.awt.Color(51, 121, 241));
        btn_Gerenc_Port.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Gerenc_Port.setForeground(new java.awt.Color(255, 255, 255));
        btn_Gerenc_Port.setText("<html>  \n<center>  \nGerenciamento <br/> dos Porteiros \n</center> \n</html>");
        btn_Gerenc_Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Gerenc_PortActionPerformed(evt);
            }
        });

        btn_Cond_In.setBackground(new java.awt.Color(51, 121, 241));
        btn_Cond_In.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Cond_In.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cond_In.setText("<html> \n<center> \nCondomínios <br/> Inativados\n</center>\n</html>");
        btn_Cond_In.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cond_InActionPerformed(evt);
            }
        });

        btn_Port_In.setBackground(new java.awt.Color(51, 121, 241));
        btn_Port_In.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Port_In.setForeground(new java.awt.Color(255, 255, 255));
        btn_Port_In.setText("<html> \n<center> \nPorteiros <br/> Inativados\n</center>\n</html>");
        btn_Port_In.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Port_InActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout back1Layout = new javax.swing.GroupLayout(back1);
        back1.setLayout(back1Layout);
        back1Layout.setHorizontalGroup(
            back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Geren_Cond, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Gerenc_Port, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cond_In, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Port_In, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(back3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        back1Layout.setVerticalGroup(
            back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back1Layout.createSequentialGroup()
                .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(back1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(back1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btn_Geren_Cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_Gerenc_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_Cond_In, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_Port_In, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Método "ActionPerformed" do botão de gerenciamento de porteiros ativos. Finalidade: acessar a interface que controla os registros dos porteiros
    private void btn_Gerenc_PortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Gerenc_PortActionPerformed
        String tipoTelaPort = "ativos";
        frm_pre_gporteiros mostra = new frm_pre_gporteiros(tipoTelaPort);
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_Gerenc_PortActionPerformed
    
    //Método "ActionPerformed" do botão de gerenciamento de condomínios ativos. Finalidade: acessar a interface que controla os registros dos condomínios
    private void btn_Geren_CondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Geren_CondActionPerformed
        frm_gerenc_condominio mostra = new frm_gerenc_condominio();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_Geren_CondActionPerformed

    //Método "ActionPerformed" do botão de gerenciamento de porteiros inativados. Finalidade: acessar a interface que controla os registros dos porteiros inativados
    private void btn_Port_InActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Port_InActionPerformed
        String tipoTelaPort = "inativos";
        frm_pre_gporteiros mostra = new frm_pre_gporteiros(tipoTelaPort);
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_Port_InActionPerformed
    
    //Método "ActionPerformed" do botão de gerenciamento de condomínios inativados. Finalidade: acessar a interface que controla os registros dos condomínios inativados
    private void btn_Cond_InActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cond_InActionPerformed
        frm_cond_inativos mostra = new frm_cond_inativos();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_Cond_InActionPerformed

    //Método "ActionPerformed" do botão "home". Finalidade: voltar para a interface de login
    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        login mostra = new login();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    //Método "ActionPerformed" do botão "exit". Finalidade: sair do sistema/fechar a aplicação
    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed
    
    //Método "logo", que define a imagem, e suas propriedades na tela:
    private void logo(){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo/SRs.png"));
        Image scaleImage = imageIcon.getImage().getScaledInstance(170, 170,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(scaleImage);
        lblLogo.setIcon(img);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back1;
    private javax.swing.JPanel back2;
    private javax.swing.JPanel back3;
    private javax.swing.JButton btn_Cond_In;
    private javax.swing.JButton btn_Geren_Cond;
    private javax.swing.JButton btn_Gerenc_Port;
    private javax.swing.JButton btn_Port_In;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_home;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
