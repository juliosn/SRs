//Declaração de pacote:
package porteiro;

//Importação de classes:
import conexao.Conexao;
import controle.login;
import java.awt.Color;
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

//Classe frm_gerenc_moradores, com herdando caracterísitcas/métodos da classe JFrame:
public class frm_gerenc_moradores extends javax.swing.JFrame {

    // Declarando um atributo para armazenar o ID do morador:
    private int idMoradorSelecionado = -1;
    
    //Métodos set e get:
    public void setIdMoradorSelecionado(int idMoradorSelecionado) {
        this.idMoradorSelecionado = idMoradorSelecionado;
    }
    
    public int getIdMoradorSelecionado() {
        return idMoradorSelecionado;
    }

    //Objeto com atributos da classe Connection. Finalidade: Ligação com Banco de Dados.
    Connection con = null;
    
    //Objeto com atributos da classe ResultSet. Finalidade: Procura dos registros do banco.
    ResultSet rs = null;
    
    /*Objeto com atributos da classe PreparedStatement. 
    Finalidade: Adicionar os dados inseridos pelo usuário na busca de dados do banco.*/
    PreparedStatement ps = null;
    
    
    //Atributos utilizados para passagem de parâmetro e comparação de dados:
    private int id_cond;
    private int id_user;
    
    /**
     * Criando o novo formulário frm_gerenc_moradores:
     */
    public frm_gerenc_moradores(int realCond, int realIdUser) {
        initComponents();
        initVars(realCond, realIdUser);
        con = Conexao.conecta();
        logo();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        try 
        {
            String pesquisa = "SELECT morador.* " +
            "FROM usuario " +
            "INNER JOIN porteiro ON usuario.id_usuario = porteiro.id_usuario " +
            "INNER JOIN condominio ON porteiro.id_condominio = condominio.id_condominio " +
            "INNER JOIN morador ON condominio.id_condominio = morador.id_condominio " +
            "WHERE porteiro.id_usuario = ?"; // Usando um parâmetro
            
            ps = con.prepareStatement(pesquisa);
            ps.setInt(1, id_user);
            rs = ps.executeQuery();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Dados não localizados!" + ex, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
        preencherTabela();
    }
    
    //Método initVars() responsável por passar parâmetros de dados do usuário e
    //adicioná-los em atributos locais (da classe):
    private void initVars(int realCond, int realIdUser)
    {        
        id_cond = realCond;
        id_user = realIdUser;
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
        btn_home = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        back3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_moradores = new javax.swing.JTable();
        lbl_Titulo = new javax.swing.JLabel();
        btn_Criar = new javax.swing.JButton();
        btn_Alterar = new javax.swing.JButton();
        btn_Excluir = new javax.swing.JButton();
        tfNumAp = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        btn_gerenc_vei = new javax.swing.JButton();
        btn_gerenc_entr = new javax.swing.JButton();
        btn_gerenc_mor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back1.setBackground(new java.awt.Color(11, 25, 49));

        back2.setBackground(new java.awt.Color(11, 25, 49));

        btn_home.setBackground(new java.awt.Color(51, 121, 241));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/home.png"))); // NOI18N
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_exit.setBackground(new java.awt.Color(51, 121, 241));
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/button/exit.png"))); // NOI18N
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
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
            .addGroup(back2Layout.createSequentialGroup()
                .addGroup(back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(back2Layout.createSequentialGroup()
                        .addContainerGap(153, Short.MAX_VALUE)
                        .addGroup(back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        back3.setBackground(new java.awt.Color(212, 223, 253));

        tbl_moradores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbl_moradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Número do Apartamento"
            }
        ));
        tbl_moradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_moradoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_moradores);

        lbl_Titulo.setBackground(new java.awt.Color(11, 25, 49));
        lbl_Titulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_Titulo.setText("MORADORES DO CONDOMÍNIO");

        btn_Criar.setBackground(new java.awt.Color(51, 121, 241));
        btn_Criar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Criar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Criar.setText("Criar");
        btn_Criar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CriarActionPerformed(evt);
            }
        });

        btn_Alterar.setBackground(new java.awt.Color(51, 121, 241));
        btn_Alterar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Alterar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Alterar.setText("Alterar");
        btn_Alterar.setEnabled(false);
        btn_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AlterarActionPerformed(evt);
            }
        });

        btn_Excluir.setBackground(new java.awt.Color(51, 121, 241));
        btn_Excluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Excluir.setForeground(new java.awt.Color(255, 255, 255));
        btn_Excluir.setText("Excluir");
        btn_Excluir.setEnabled(false);
        btn_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExcluirActionPerformed(evt);
            }
        });

        tfNumAp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfNumAp.setForeground(new java.awt.Color(153, 153, 153));
        tfNumAp.setText("Digite o Número...");
        tfNumAp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNumApFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNumApFocusLost(evt);
            }
        });
        tfNumAp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNumApKeyTyped(evt);
            }
        });

        tfNome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfNome.setForeground(new java.awt.Color(153, 153, 153));
        tfNome.setText("Digite o Nome...");
        tfNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNomeFocusLost(evt);
            }
        });

        javax.swing.GroupLayout back3Layout = new javax.swing.GroupLayout(back3);
        back3.setLayout(back3Layout);
        back3Layout.setHorizontalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back3Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                    .addComponent(lbl_Titulo)
                    .addGroup(back3Layout.createSequentialGroup()
                        .addComponent(btn_Criar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Alterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Excluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(170, 170, 170))
            .addGroup(back3Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNumAp)
                    .addComponent(tfNome))
                .addGap(348, 348, 348))
        );
        back3Layout.setVerticalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(tfNumAp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Criar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(lbl_Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        btn_gerenc_vei.setBackground(new java.awt.Color(51, 121, 241));
        btn_gerenc_vei.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_gerenc_vei.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerenc_vei.setText("<html>  \n<center>  \nGerenciamento <br/> de Veículos\n</center> \n</html>");
        btn_gerenc_vei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenc_veiActionPerformed(evt);
            }
        });

        btn_gerenc_entr.setBackground(new java.awt.Color(51, 121, 241));
        btn_gerenc_entr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_gerenc_entr.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerenc_entr.setText("<html> \n<center> \nRegistro <br/> de Entrada\n</center>\n</html>");
        btn_gerenc_entr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenc_entrActionPerformed(evt);
            }
        });

        btn_gerenc_mor.setBackground(new java.awt.Color(0, 53, 143));
        btn_gerenc_mor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_gerenc_mor.setForeground(new java.awt.Color(255, 255, 255));
        btn_gerenc_mor.setText("<html>  \n<center>  \nGerenciamento <br/> dos Moradores\n</center> \n</html>");
        btn_gerenc_mor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gerenc_morActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout back1Layout = new javax.swing.GroupLayout(back1);
        back1.setLayout(back1Layout);
        back1Layout.setHorizontalGroup(
            back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(back1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_gerenc_entr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_gerenc_vei, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_gerenc_mor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(back3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        back1Layout.setVerticalGroup(
            back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back1Layout.createSequentialGroup()
                .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(back1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btn_gerenc_mor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_gerenc_vei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_gerenc_entr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(back1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
            ps.setInt(1, id_user);

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
            JOptionPane.showMessageDialog(null, "Dados não localizados!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }        
    }//GEN-LAST:event_btn_gerenc_morActionPerformed

    //Método "ActionPerformed" do botão de criação de registro. Finalidade: criar um novo registro de morador
    private void btn_CriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CriarActionPerformed
        
        //Armazenando os valores dos campos de texto:
        String nome = tfNome.getText();
        String numAp = tfNumAp.getText();
        
        //Verificando se o porteiro inseriu alguma informação
        if("Digite o Nome...".equals(nome) || "Digite o Número...".equals(numAp))
        {
               JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos solicitados!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                //Comando SQL:
                String insert_sql="INSERT into morador (id_condominio,nome_morador,numeroAp) values ('" + id_cond + "','" + nome + "','" + numAp + "')";
                
                //Execução do comando SQL:
                ps.executeUpdate(insert_sql);
                
                //Informando gravação realizada com sucesso:
                JOptionPane.showMessageDialog(null, "Gravação Realizada com sucesso!!!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);


                //Comando SQL:
                String pesquisa = "SELECT morador.* " +
                "FROM usuario " +
                "INNER JOIN porteiro ON usuario.id_usuario = porteiro.id_usuario " +
                "INNER JOIN condominio ON porteiro.id_condominio = condominio.id_condominio " +
                "INNER JOIN morador ON condominio.id_condominio = morador.id_condominio " +
                "WHERE porteiro.id_usuario = ?"; // Usando um parâmetro

                /*Comando que "prepara" declaração para busca no banco, onde os dados 
                inseridos serão colocados no lugar do '?' de cada campo do select*/
                ps = con.prepareStatement(pesquisa);

                //Adicionando os dados inseridos ao parâmetro:
                ps.setInt(1, id_cond);

                //Execução da busca:
                rs = ps.executeQuery();
                rs.first();
                
                //Chamando o Método preencherTabela():
                preencherTabela();
                
                //Chamando o Método limparCampos():
                limparCampos();
            }
            catch(SQLException errosql)
            {
                JOptionPane.showMessageDialog(null, "\n Erro ao gravar os dados" + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
        
    }//GEN-LAST:event_btn_CriarActionPerformed

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
            ps.setInt(1, id_user);

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
    private void btn_gerenc_entrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gerenc_entrActionPerformed
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
            ps.setInt(1, id_user);

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
    }//GEN-LAST:event_btn_gerenc_entrActionPerformed

    //Método "FocusGained" do campo de texto 'nome', que retira a máscara do texto:
    private void tfNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusGained
        if(tfNome.getText().equals("Digite o Nome..."))
        {
            tfNome.setText("");
            tfNome.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfNomeFocusGained

    //Método "FocusLost" do campo de texto 'nome', que insere a máscara do texto:
    private void tfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusLost
        if(tfNome.getText().equals(""))
        {
            tfNome.setText("Digite o Nome...");
            tfNome.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_tfNomeFocusLost

    //Método "FocusLost" do campo de texto 'número de apartamento', que insere a máscara do texto:
    private void tfNumApFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNumApFocusLost
        if(tfNome.getText().equals(""))
        {
            tfNome.setText("Digite o Número...");
            tfNome.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_tfNumApFocusLost

    //Método "FocusGained" do campo de texto 'número de apartamento', que retira a máscara do texto:
    private void tfNumApFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNumApFocusGained
        if(tfNumAp.getText().equals("Digite o Número..."))
        {
            tfNumAp.setText("");
            tfNumAp.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfNumApFocusGained

    /*Esse evento servirá para ativar o botão de alteração/exclusão ao selecionar um registro na tabela 
    com o clique do mouse: */
    private void tbl_moradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_moradoresMouseClicked
        int linha_selecionada = tbl_moradores.getSelectedRow();
        tfNome.setText(tbl_moradores.getValueAt(linha_selecionada, 0).toString());
        tfNome.setForeground(new Color(0,0,0));
        tfNumAp.setText(tbl_moradores.getValueAt(linha_selecionada, 1).toString());
        tfNumAp.setForeground(new Color(0,0,0));
        
        // Verifique se uma linha foi selecionada
        if (linha_selecionada >= 0) {
        String nome = (String) tbl_moradores.getValueAt(linha_selecionada, 0);
        String numAp = (String) tbl_moradores.getValueAt(linha_selecionada, 1);
        
        // Executando uma consulta para obter o ID do morador com base no nome e número do apartamento:
        try {
            String pesquisaIdMorador = "SELECT num_registro FROM morador WHERE nome_morador = ? AND numeroAp = ?";
            ps = con.prepareStatement(pesquisaIdMorador);
            ps.setString(1, nome);
            ps.setString(2, numAp);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                int idMorador = rs.getInt("num_registro");
                setIdMoradorSelecionado(idMorador);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter os dados requisitados!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
        }
    }
        
        btn_Alterar.setEnabled(true);
        btn_Excluir.setEnabled(true);
        btn_Criar.setEnabled(false);
    }//GEN-LAST:event_tbl_moradoresMouseClicked

    //Método "ActionPerformed" do botão de exclusão de registro. Finalidade: excluir um novo registro de morador
    private void btn_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExcluirActionPerformed
        
        //Armazenando valores dos campos de texto e linha selecionada em atributos:
        int linha_selecionada = tbl_moradores.getSelectedRow();
        String nome = tfNome.getText();
        String numAp = tfNumAp.getText();
        
        //Comandos SQL/Informações:
        String sql= "";
        String msg= "";

        //Verificando se foram inseridos valores nos campos de texto:
        if("Digite o Nome...".equals(nome) || "Digite o Número...".equals(numAp))
        {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos solicitados!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            //Verificando se os dados são válidos:
            if(linha_selecionada == tbl_moradores.getSelectedRow() && nome.equals(tfNome.getText()) && numAp.equals(tfNumAp.getText()))
            {
                try
                {
                    //Verificando se algum registro foi realmente selecionado:
                    if(getIdMoradorSelecionado() != -1){
                        sql = "DELETE FROM morador WHERE num_registro = ?";
                        msg = "Exclusão de registro";

                        ps = con.prepareStatement(sql);
                        ps.setInt(1, getIdMoradorSelecionado());

                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(null, msg + " realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    //Atualização de tabela:
                    ps = con.prepareStatement("SELECT morador.* " +
                        "FROM usuario " +
                        "INNER JOIN porteiro ON usuario.id_usuario = porteiro.id_usuario " +
                        "INNER JOIN condominio ON porteiro.id_condominio = condominio.id_condominio " +
                        "INNER JOIN morador ON condominio.id_condominio = morador.id_condominio " +
                        "WHERE porteiro.id_usuario = ?");
                    
                    ps.setInt(1, id_cond);
                    rs = ps.executeQuery();
                    rs.first();
                    preencherTabela();
                    
                    //Definindo para as configurações iniciais:
                    limparCampos();
                    btn_Alterar.setEnabled(false);
                    btn_Excluir.setEnabled(false);
                    btn_Criar.setEnabled(true);

                }
                catch(SQLException errosql)
                {
                    JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Erro ao selecionar registro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_ExcluirActionPerformed

    //Método "ActionPerformed" do botão de alteração de registro. Finalidade: alterar um novo registro de morador
    private void btn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarActionPerformed
        
        //Armazenando valores dos campos de texto e linha selecionada em atributos:
        int linha_selecionada = tbl_moradores.getSelectedRow();
        String nome = tfNome.getText();
        String numAp = tfNumAp.getText();
        
        //Comandos SQL/Informações:
        String sql= "";
        String msg= "";

        //Verificando se foram inseridos valores nos campos de texto:
        if("Digite o Nome...".equals(nome) || "Digite o Número...".equals(numAp))
        {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos solicitados!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            //Verificando se os dados são válidos:
            if(linha_selecionada == tbl_moradores.getSelectedRow() && nome.equals(tfNome.getText()) && numAp.equals(tfNumAp.getText()))
            {
                try
                {
                    //Verificando se algum registro foi realmente selecionado:
                    if(getIdMoradorSelecionado() != -1){
                        sql = "UPDATE morador SET nome_morador = ?, numeroAp = ? WHERE num_registro = ?";
                        msg = "Alteração de registro";

                        ps = con.prepareStatement(sql);
                        ps.setString(1, nome);
                        ps.setString(2, numAp);
                        ps.setInt(3, getIdMoradorSelecionado());

                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(null, msg + " realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    //Atualização de tabela:
                    ps = con.prepareStatement("SELECT morador.* " +
                        "FROM usuario " +
                        "INNER JOIN porteiro ON usuario.id_usuario = porteiro.id_usuario " +
                        "INNER JOIN condominio ON porteiro.id_condominio = condominio.id_condominio " +
                        "INNER JOIN morador ON condominio.id_condominio = morador.id_condominio " +
                        "WHERE porteiro.id_usuario = ?");
                    ps.setInt(1, id_cond);
                    rs = ps.executeQuery();
                    rs.first();
                    preencherTabela();
                    
                    //Definindo para as configurações iniciais:
                    limparCampos();
                    btn_Alterar.setEnabled(false);
                    btn_Excluir.setEnabled(false);
                    btn_Criar.setEnabled(true);

                }
                catch(SQLException errosql)
                {
                    JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Erro ao selecionar registro!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_AlterarActionPerformed

    private void tfNumApKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNumApKeyTyped
        String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        if(!caracteres.contains(evt.getKeyChar() + "")){
            evt.consume();
        }        
    }//GEN-LAST:event_tfNumApKeyTyped

    //Método "logo", que define a imagem, e suas propriedades na tela:
    private void logo(){
            ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo/SRs.png"));
            Image scaleImage = imageIcon.getImage().getScaledInstance(170, 170,Image.SCALE_DEFAULT);
            ImageIcon img = new ImageIcon(scaleImage);
            lblLogo.setIcon(img);
    }
    
    //Esse método chama os componentes da tabela do banco, e os colocam no jtable:
    private void preencherTabela(){
        tbl_moradores.getColumnModel().getColumn(0).setPreferredWidth(120);
        tbl_moradores.getColumnModel().getColumn(1).setPreferredWidth(120);
        
        DefaultTableModel modelo = (DefaultTableModel) tbl_moradores.getModel();
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
                            rs.getString("nome_morador"), rs.getString("numeroAp")
                        }
                );
            }
        }
        catch(SQLException erro)
        {
            JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!! :\n ","Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
    //Esse método redefine os campos presentes na interface, voltando para o seu estado inicial:
    private void limparCampos()
    {
        tfNome.setText("Digite o Nome...");
        tfNome.setForeground(new Color(153,153,153));
        tfNumAp.setText("Digite o Número...");
        tfNumAp.setForeground(new Color(153,153,153));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back1;
    private javax.swing.JPanel back2;
    private javax.swing.JPanel back3;
    private javax.swing.JButton btn_Alterar;
    private javax.swing.JButton btn_Criar;
    private javax.swing.JButton btn_Excluir;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_gerenc_entr;
    private javax.swing.JButton btn_gerenc_mor;
    private javax.swing.JButton btn_gerenc_vei;
    private javax.swing.JButton btn_home;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lbl_Titulo;
    private javax.swing.JTable tbl_moradores;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumAp;
    // End of variables declaration//GEN-END:variables
}
