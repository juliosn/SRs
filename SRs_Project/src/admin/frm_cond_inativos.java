//Declaração de pacote:
package admin;

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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Júlio, Maria e Victor
 */

//Classe frm_cond_inativos, com herdando caracterísitcas/métodos da classe JFrame:
public class frm_cond_inativos extends javax.swing.JFrame {

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
    public frm_cond_inativos() {
        con = Conexao.conecta();
        initComponents();
        logo();
        try 
        {
            String pesquisa = "SELECT * FROM condominio WHERE situacao = 'inativo' ORDER BY id_condominio";
            ps = con.prepareStatement(pesquisa);
            rs = ps.executeQuery();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Dados não localizados!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
        preencherTabela();
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
        btn_Reat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Cond_In = new javax.swing.JTable();
        lbl_Desc = new javax.swing.JLabel();
        lbl_Titulo = new javax.swing.JLabel();
        btn_gerenc_cond = new javax.swing.JButton();
        btn_gerenc_port = new javax.swing.JButton();
        btn_cond_in = new javax.swing.JButton();
        btn_port_in = new javax.swing.JButton();

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
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(back2Layout.createSequentialGroup()
                        .addGap(0, 147, Short.MAX_VALUE)
                        .addGroup(back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        back3.setBackground(new java.awt.Color(212, 223, 253));

        btn_Reat.setBackground(new java.awt.Color(51, 121, 241));
        btn_Reat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Reat.setForeground(new java.awt.Color(255, 255, 255));
        btn_Reat.setText("Reativar Condomínio\n");
        btn_Reat.setEnabled(false);
        btn_Reat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReatActionPerformed(evt);
            }
        });

        tbl_Cond_In.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbl_Cond_In.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "CNPJ", "CEP", "Endereço", "Bairro", "Cidade", "UF"
            }
        ));
        tbl_Cond_In.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_Cond_InMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Cond_In);

        lbl_Desc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_Desc.setForeground(new java.awt.Color(11, 25, 49));
        lbl_Desc.setText("Selecione o condomínio para poder reativá-lo");

        lbl_Titulo.setBackground(new java.awt.Color(11, 25, 49));
        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_Titulo.setForeground(new java.awt.Color(11, 25, 49));
        lbl_Titulo.setText("CONDOMÍNIOS INATIVADOS");

        javax.swing.GroupLayout back3Layout = new javax.swing.GroupLayout(back3);
        back3.setLayout(back3Layout);
        back3Layout.setHorizontalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back3Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Desc)
                    .addComponent(lbl_Titulo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                    .addComponent(btn_Reat, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(164, 164, 164))
        );
        back3Layout.setVerticalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Desc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Reat, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        btn_gerenc_cond.setBackground(new java.awt.Color(51, 121, 241));
        btn_gerenc_cond.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_gerenc_cond.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerenc_cond.setText("<html>  \n<center>  \nGerenciamento <br/> de Condomínios \n</center> \n</html>");
        btn_gerenc_cond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenc_condActionPerformed(evt);
            }
        });

        btn_gerenc_port.setBackground(new java.awt.Color(51, 121, 241));
        btn_gerenc_port.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_gerenc_port.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerenc_port.setText("<html>  \n<center>  \nGerenciamento <br/> dos Porteiros \n</center> \n</html>");
        btn_gerenc_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenc_portActionPerformed(evt);
            }
        });

        btn_cond_in.setBackground(new java.awt.Color(0, 53, 143));
        btn_cond_in.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_cond_in.setForeground(new java.awt.Color(255, 255, 255));
        btn_cond_in.setText("<html> \n<center> \nCondomínios <br/> Inativados\n</center>\n</html>\n");
        btn_cond_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cond_inActionPerformed(evt);
            }
        });

        btn_port_in.setBackground(new java.awt.Color(51, 121, 241));
        btn_port_in.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_port_in.setForeground(new java.awt.Color(255, 255, 255));
        btn_port_in.setText("<html> \n<center> \nPorteiros <br/> Inativados\n</center>\n</html>");
        btn_port_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_port_inActionPerformed(evt);
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
                    .addComponent(btn_gerenc_cond, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_gerenc_port, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cond_in, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_port_in, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(btn_gerenc_cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_gerenc_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_cond_in, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_port_in, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    //Método "ActionPerformed" do botão de gerenciamento de porteiros ativos. Finalidade: acessar a interface que controla os registros dos porteiros.
    private void btn_gerenc_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerenc_portActionPerformed
        String tipoTelaPort = "ativos";
        frm_pre_gporteiros mostra = new frm_pre_gporteiros(tipoTelaPort);
        mostra.setVisible(true);
        dispose();        
    }//GEN-LAST:event_btn_gerenc_portActionPerformed

    //Método "ActionPerformed" do botão de gerenciamento de condomínios ativos. Finalidade: acessar a interface que controla os registros dos condomínios
    private void btn_gerenc_condActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerenc_condActionPerformed
        frm_gerenc_condominio mostra = new frm_gerenc_condominio();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_gerenc_condActionPerformed

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

    //Método "ActionPerformed" do botão de gerenciamento de condomínios inativados. Finalidade: acessar a interface que controla os registros dos condomínios inativados
    private void btn_cond_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cond_inActionPerformed
       frm_cond_inativos mostra = new frm_cond_inativos();
       mostra.setVisible(true);
       dispose();
    }//GEN-LAST:event_btn_cond_inActionPerformed

    //Método "ActionPerformed" do botão de gerenciamento de porteiros inativados. Finalidade: acessar a interface que controla os registros dos porteiros inativados
    private void btn_port_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_port_inActionPerformed
        String tipoTelaPort = "inativos";
        frm_pre_gporteiros mostra = new frm_pre_gporteiros(tipoTelaPort);
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_port_inActionPerformed

    //Método "ActionPerformed" do botão da reativação dos condomínios. Finalidade: reativar registros de condomínios inativados previamente
    private void btn_ReatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReatActionPerformed
        
        //Permitindo a seleção de um registro da tabela:
        tbl_Cond_In.setRowSelectionAllowed(true);
        
        //Armazenando a linha do registro selecionado em um atributo:
        int linha_selecionada = tbl_Cond_In.getSelectedRow();
        
        //Armazenando o valor do cnpj do registro selecionado:
        String cnpj = tbl_Cond_In.getValueAt(linha_selecionada, 1).toString();
        
        //Verificando se um registro foi realmente selecionado:
        if (linha_selecionada >= 0) {                       
            
            //Declarando atributo que será utilizado para reativar um registro no comando sql
            String situacao = "ativo";        
            //Atributo que armazenará o comando sql
            String sql= "";
            //Atributo que armazerá uma descrição da ação que está ocorrendo
            String msg= "";

            try
            {
                //Comando SQL:
                String pesquisa = "SELECT * FROM condominio WHERE cnpj=?";
                /*Comando que "prepara" declaração para busca no banco, onde os dados 
                inseridos serão colocados no lugar do '?' de cada campo do select*/
                ps = con.prepareStatement(pesquisa);

                //Adicionando os dados inseridos:
                ps.setString(1, cnpj);

                //Execução da busca:
                rs = ps.executeQuery();

                //Verificando se o registro existe:
                if(rs.next())
                {
                    //Armazenando o id (chave-primária) do registro:
                    int realId = rs.getInt("id_condominio");

                    //Inserindo o comando sql que será executado:
                    sql = "UPDATE condominio set situacao='" + situacao + "' where id_condominio = " + realId;
                    //Inserindo a descrição da ação sql
                    msg = "Reativação de registro";
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Não é possível alterar um registro não existente! ", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
                }
                //Executando comando sql:
                ps.executeUpdate(sql);
                //Informando que a ação foi realizada:
                JOptionPane.showMessageDialog(null, msg + " realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                //Atualizando tabela dos condomínios inativados:
                ps = con.prepareStatement("SELECT * FROM condominio WHERE situacao = 'inativo' ORDER BY id_condominio");
                rs = ps.executeQuery();
                rs.first();
                preencherTabela();
                //Desativando botão, pois o usuário só pode utilizá-lo ao selecionar um registro:
                btn_Reat.setEnabled(false);
            }
            catch(SQLException errosql)
            {
                JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } 
    }//GEN-LAST:event_btn_ReatActionPerformed

    /*Esse evento servirá para ativar o botão de reativação ao selecionar um registro na tabela 
    com o clique do mouse: */
    private void tbl_Cond_InMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Cond_InMouseClicked
        //Ativando botão, pois o usuário selecionou um registro:
        btn_Reat.setEnabled(true);
    }//GEN-LAST:event_tbl_Cond_InMouseClicked
    
    //Método "logo", que define a imagem, e suas propriedades na tela:
    private void logo(){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo/SRs.png"));
        Image scaleImage = imageIcon.getImage().getScaledInstance(170, 170,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(scaleImage);
        lblLogo.setIcon(img);
    }
    
    //Esse método chama os componentes da tabela do banco, e os coloca no jtable:
    private void preencherTabela(){
        tbl_Cond_In.getColumnModel().getColumn(0).setPreferredWidth(120);
        tbl_Cond_In.getColumnModel().getColumn(1).setPreferredWidth(60);
        tbl_Cond_In.getColumnModel().getColumn(2).setPreferredWidth(60);
        tbl_Cond_In.getColumnModel().getColumn(3).setPreferredWidth(60);
        tbl_Cond_In.getColumnModel().getColumn(4).setPreferredWidth(60);
        tbl_Cond_In.getColumnModel().getColumn(5).setPreferredWidth(60);
        tbl_Cond_In.getColumnModel().getColumn(6).setPreferredWidth(4);
        
        DefaultTableModel modelo = (DefaultTableModel) tbl_Cond_In.getModel();
        modelo.setNumRows(0);
        
        try 
        {
            rs.beforeFirst();
            while(rs.next())
            {
                modelo.addRow
                (
                        new Object[]
                        {
                            rs.getString("nome_condominio"), rs.getString("cnpj"), rs.getString("cep"), rs.getString("endereco"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("uf")
                        }
                );
            }
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!! :\n ","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back1;
    private javax.swing.JPanel back2;
    private javax.swing.JPanel back3;
    private javax.swing.JButton btn_Reat;
    private javax.swing.JButton btn_cond_in;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_gerenc_cond;
    private javax.swing.JButton btn_gerenc_port;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_port_in;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lbl_Desc;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTable tbl_Cond_In;
    // End of variables declaration//GEN-END:variables
}
