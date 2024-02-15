//Declaração de pacote:
package porteiro;

//Importação de classes:
import conexao.Conexao;
import controle.login;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Júlio, Maria e Victor
 */

//Classe frm_menu_porteiro, com herdando caracterísitcas/métodos da classe JFrame:
public class frm_menu_porteiro extends javax.swing.JFrame {

    //Objeto com atributos da classe Connection. Finalidade: Ligação com Banco de Dados.
    Connection con = null;
    
    //Objeto com atributos da classe ResultSet. Finalidade: Procura dos registros do banco.
    ResultSet rs = null;
    
    /*Objeto com atributos da classe PreparedStatement. 
    Finalidade: Adicionar os dados inseridos pelo usuário na busca de dados do banco.*/
    PreparedStatement ps = null;
    
    //Objeto com atributos da classe frm_Login. Finalidade: Validação de login do usuário.
    login login;
    
    //Atributos utilizados para passagem de parâmetro e comparação de dados:
    private int id;
    private int usuario;
    
    /**
     * Criando o novo formulário frm_menu_porteiro:
     */
    public frm_menu_porteiro(int realId, int realUser) {
        initComponents();
        initVars(realId, realUser);
        con = Conexao.conecta();
        login = new login();
        logo();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
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
        btn_gerenc_mor = new javax.swing.JButton();
        btn_gerenc_vei = new javax.swing.JButton();
        btn_reg_entr = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back1.setBackground(new java.awt.Color(11, 25, 49));

        back2.setBackground(new java.awt.Color(11, 25, 49));

        btn_exit.setBackground(new java.awt.Color(51, 121, 241));
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/exit.png"))); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGroup(back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
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

        btn_gerenc_mor.setBackground(new java.awt.Color(51, 121, 241));
        btn_gerenc_mor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_gerenc_mor.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerenc_mor.setText("<html> \n<center> \nGerenciamento <br/> dos Moradores\n</center>\n</html>");
        btn_gerenc_mor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenc_morActionPerformed(evt);
            }
        });

        btn_gerenc_vei.setBackground(new java.awt.Color(51, 121, 241));
        btn_gerenc_vei.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_gerenc_vei.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerenc_vei.setText("<html> \n<center> \nGerenciamento <br/> de Veículos\n</center>\n</html>");
        btn_gerenc_vei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenc_veiActionPerformed(evt);
            }
        });

        btn_reg_entr.setBackground(new java.awt.Color(51, 121, 241));
        btn_reg_entr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_reg_entr.setForeground(new java.awt.Color(255, 255, 255));
        btn_reg_entr.setText("<html> \n<center> \nRegistro <br/> de Entrada\n</center>\n</html>");
        btn_reg_entr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reg_entrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout back1Layout = new javax.swing.GroupLayout(back1);
        back1.setLayout(back1Layout);
        back1Layout.setHorizontalGroup(
            back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_gerenc_mor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_gerenc_vei, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reg_entr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(btn_gerenc_mor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_gerenc_vei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_reg_entr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    //Método "ActionPerformed" do botão de gerenciamento de moradores. Finalidade: acessar a interface que controla os registros dos moradores.
    private void btn_gerenc_morActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerenc_morActionPerformed
        try 
        {
            //Comando SQL
            String pesquisa = "SELECT porteiro.id_condominio, usuario.id_usuario " +
                              "FROM porteiro " +
                              "INNER JOIN usuario ON porteiro.id_usuario = usuario.id_usuario " +
                              "WHERE usuario.id_usuario = ?"; // Usando um parâmetro

            /*Comando que "prepara" declaração para busca no banco, onde os dados 
            inseridos serão colocados no lugar do '?' de cada campo do select*/
            ps = con.prepareStatement(pesquisa);
            
            //Adicionando os dados inseridos ao parâmetro:
            ps.setInt(1, id);

            //Execução da busca:
            rs = ps.executeQuery();

            //Validando o registro do porteiro:
            if(rs.next()) {
                /*Chamando alguns atributos da tabela do banco para a passagem de 
                parâmetro e indo para tela de gerenciamento de moradores:*/
                int realCond = rs.getInt("id_condominio");
                int realIdUser = rs.getInt("id_usuario");
                
                //Acessando a interface de gerenciamento de moradores:
                frm_gerenc_moradores mostra = new frm_gerenc_moradores(realCond, realIdUser);
                mostra.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Identificação de Condomínio falhou, por favor, consulte a empresa para mais detalhes!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Dados não localizados!" + ex, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_gerenc_morActionPerformed

    //Método "ActionPerformed" do botão "home". Finalidade: voltar para a interface de login    
    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        login mostra = new login();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    //Método "ActionPerformed" do botão "exit". Finalidade: sair do sistema/fechar a aplicação.    
    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    //Método "ActionPerformed" do botão de gerenciamento de veículos. Finalidade: acessar a interface que controla os registros dos veículos.
    private void btn_gerenc_veiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerenc_veiActionPerformed
        try 
        {
            //Comando SQL
            String pesquisa = "SELECT porteiro.id_condominio, usuario.id_usuario " +
                              "FROM veiculos " +
                              "INNER JOIN morador ON veiculos.num_registro = morador.num_registro " +
                              "INNER JOIN condominio ON morador.id_condominio = condominio.id_condominio " +
                              "INNER JOIN porteiro ON condominio.id_condominio = porteiro.id_condominio " +
                              "INNER JOIN usuario ON porteiro.id_usuario = usuario.id_usuario " +
                              "WHERE usuario.id_usuario = ?"; // Usando um parâmetro

            /*Comando que "prepara" declaração para busca no banco, onde os dados 
            inseridos serão colocados no lugar do '?' de cada campo do select*/
            ps = con.prepareStatement(pesquisa);
            
            //Adicionando os dados inseridos ao parâmetro:
            ps.setInt(1, id);

            //Execução da busca:
            rs = ps.executeQuery();

            //Validando o registro do porteiro:
            if(rs.next()) {
                /*Chamando alguns atributos da tabela do banco para a passagem de 
                parâmetro e indo para tela de gerenciamento de moradores:*/
                int realCond = rs.getInt("id_condominio");
                int realIdUser = rs.getInt("id_usuario");
                
                //Acessando a interface de gerenciamento de moradores:
                frm_gerenc_veiculos mostra = new frm_gerenc_veiculos(realCond, realIdUser);
                mostra.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Identificação de Condomínio falhou, por favor, consulte a empresa para mais detalhes!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Dados não localizados!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_gerenc_veiActionPerformed

    //Método "ActionPerformed" do botão de gerenciamento de entrada. Finalidade: acessar a interface que controla os registros de entrada.
    private void btn_reg_entrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reg_entrActionPerformed
        try 
        {
            //Comando SQL
            String pesquisa = "SELECT porteiro.id_condominio, usuario.id_usuario " +
                              "FROM entrada " +
                              "INNER JOIN veiculos ON entrada.id_veiculos = veiculos.id_veiculos " +
                              "INNER JOIN morador ON veiculos.num_registro = morador.num_registro " +
                              "INNER JOIN condominio ON morador.id_condominio = condominio.id_condominio " +
                              "INNER JOIN porteiro ON condominio.id_condominio = porteiro.id_condominio " +
                              "INNER JOIN usuario ON porteiro.id_usuario = usuario.id_usuario " +
                              "WHERE usuario.id_usuario = ?"; // Usando um parâmetro

            /*Comando que "prepara" declaração para busca no banco, onde os dados 
            inseridos serão colocados no lugar do '?' de cada campo do select*/
            ps = con.prepareStatement(pesquisa);
            
            //Adicionando os dados inseridos ao parâmetro:
            ps.setInt(1, id);

            //Execução da busca:
            rs = ps.executeQuery();

            //Validando o registro do porteiro:
            if(rs.next()) 
            {
                /*Chamando alguns atributos da tabela do banco para a passagem de 
                parâmetro e indo para tela de gerenciamento de moradores:*/
                int realCond = rs.getInt("id_condominio");
                int realIdUser = rs.getInt("id_usuario");     
                
                //Acessando a interface de gerenciamento de entrada:
                frm_gerenc_entrada mostra = new frm_gerenc_entrada(realCond, realIdUser);
                mostra.setVisible(true);
                dispose();
                
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Identificação de Condomínio falhou, por favor, consulte a empresa para mais detalhes!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Dados não localizados!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_reg_entrActionPerformed

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
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_gerenc_mor;
    private javax.swing.JButton btn_gerenc_vei;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_reg_entr;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
