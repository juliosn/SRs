package admin;

import validacao.ValidadorCNPJ;
import validacao.ViaCEP;
import conexao.Conexao;
import controle.login;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Júlio, Maria e Victor
 */
public class frm_gerenc_condominio extends javax.swing.JFrame {

    private int idCondominioSelecionado;
    
    /**
     * @return the idCondominioSelecionado
     */
    public int getIdCondominioSelecionado() {
        return idCondominioSelecionado;
    }

    /**
     * @param idCondominioSelecionado the idCondominioSelecionado to set
     */
    public void setIdCondominioSelecionado(int idCondominioSelecionado) {
        this.idCondominioSelecionado = idCondominioSelecionado;
    }

    //Objeto com atributos da classe Connection. Finalidade: Ligação com Banco de Dados.
    Connection con = null;
    
    //Objeto com atributos da classe ResultSet. Finalidade: Procura dos registros do banco.
    ResultSet rs = null;
    
    /*Objeto com atributos da classe PreparedStatement. 
    Finalidade: Adicionar os dados inseridos pelo usuário na busca de dados do banco.*/
    PreparedStatement ps = null;

    
    /**
     * Creates new form frm_gerenc_condominio
     */
    public frm_gerenc_condominio() {
        initComponents();
        logo();
        con = Conexao.conecta();
        try 
        {
            String pesquisa = "SELECT * FROM condominio WHERE situacao = 'ativo' ORDER BY id_condominio";
            ps = con.prepareStatement(pesquisa);
            rs = ps.executeQuery();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Dados não localizados!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
        preencherTabela();
        tfCNPJ.setText("Digite o CNPJ...");
        tfCNPJ.setForeground(new Color(153, 153, 153));

        // Crie um DefaultFormatterFactory vazio para desativar a máscara
        tfCNPJ.setFormatterFactory(new DefaultFormatterFactory());
        
        tfCNPJ.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tfCNPJ.setForeground(new Color(0, 0, 0));

                // Ative a máscara quando o campo ganhar foco
                try {
                    MaskFormatter mask = new MaskFormatter("##.###.###/####-##");
                    mask.setPlaceholderCharacter('_');
                    tfCNPJ.setFormatterFactory(new DefaultFormatterFactory(mask));
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar campo!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfCNPJ.getText().equals("  .   .   /    -  ")) {
                    tfCNPJ.setText("Digite o CNPJ...");
                    tfCNPJ.setForeground(new Color(153, 153, 153));

                    // Desative a máscara quando o campo perder o foco
                    tfCNPJ.setFormatterFactory(new DefaultFormatterFactory());
                }
            }
        });

        // Crie o JFormattedTextField com o texto de instrução
        tfCEP.setText("Digite o CEP...");
        tfCEP.setForeground(new Color(153, 153, 153));

        // Configure o ouvinte de foco para ativar a máscara e restaurar o texto de instrução
        tfCEP.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tfCEP.setForeground(new Color(0, 0, 0));

                // Ative a máscara quando o campo ganhar foco
                try {
                    MaskFormatter mask = new MaskFormatter("#####-###");
                    mask.setPlaceholderCharacter('_');
                    tfCEP.setFormatterFactory(new DefaultFormatterFactory(mask));
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao gerar campo!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tfCEP.getText().equals("_____-___")) {
                    tfCEP.setText("Digite o CEP...");
                    tfCEP.setForeground(new Color(153, 153, 153));

                    // Desative a máscara quando o campo perder o foco
                    tfCEP.setFormatterFactory(new DefaultFormatterFactory());
                }
                else
                {
                    String cep = tfCEP.getText();
                    try{
                        String resultado = ViaCEP.consultarCEP(cep);
                        JSONObject json = (JSONObject) new JSONParser().parse(resultado);

                        String endereco = (String) json.get("logradouro");
                        String bairro = (String) json.get("bairro");
                        String cidade = (String) json.get("localidade");
                        String uf = (String) json.get("uf");

                        tfEnd.setText(endereco);
                        tfEnd.setForeground(new Color(0,0,0));
                        tfBairro.setText(bairro);
                        tfBairro.setForeground(new Color(0,0,0));
                        tfCidade.setText(cidade);
                        tfCidade.setForeground(new Color(0,0,0));
                        tfUF.setText(uf);
                        tfUF.setForeground(new Color(0,0,0));

                    } catch(Exception er){
                        JOptionPane.showMessageDialog(null, "Erro ao consultar o CEP: " + er.getMessage(), "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
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

        back1 = new javax.swing.JPanel();
        back3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Cond_Atv = new javax.swing.JTable();
        lblTitle2 = new javax.swing.JLabel();
        btn_Criar = new javax.swing.JButton();
        btn_Alterar = new javax.swing.JButton();
        btn_Inativar = new javax.swing.JButton();
        tfBairro = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        tfEnd = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        tfUF = new javax.swing.JTextField();
        tfCNPJ = new javax.swing.JFormattedTextField();
        tfCEP = new javax.swing.JFormattedTextField();
        back2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_Cond_In = new javax.swing.JButton();
        btn_Gerenc_Cond = new javax.swing.JButton();
        btn_Geren_Port = new javax.swing.JButton();
        btn_Port_In = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back1.setBackground(new java.awt.Color(11, 25, 49));

        back3.setBackground(new java.awt.Color(212, 223, 253));

        tbl_Cond_Atv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tbl_Cond_Atv.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Cond_Atv.getTableHeader().setResizingAllowed(false);
        tbl_Cond_Atv.getTableHeader().setReorderingAllowed(false);
        tbl_Cond_Atv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_Cond_AtvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Cond_Atv);

        lblTitle2.setBackground(new java.awt.Color(11, 25, 49));
        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle2.setText("CONDOMÍNIOS ATIVOS");

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

        btn_Inativar.setBackground(new java.awt.Color(51, 121, 241));
        btn_Inativar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Inativar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Inativar.setText("Inativar");
        btn_Inativar.setToolTipText("");
        btn_Inativar.setEnabled(false);
        btn_Inativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InativarActionPerformed(evt);
            }
        });

        tfBairro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfBairro.setForeground(new java.awt.Color(153, 153, 153));
        tfBairro.setText("Digite o Bairro...");
        tfBairro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBairroFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBairroFocusLost(evt);
            }
        });

        tfCidade.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfCidade.setForeground(new java.awt.Color(153, 153, 153));
        tfCidade.setText("Digite a Cidade...");
        tfCidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCidadeFocusLost(evt);
            }
        });

        tfEnd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfEnd.setForeground(new java.awt.Color(153, 153, 153));
        tfEnd.setText("Digite o Endereço...");
        tfEnd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfEndFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEndFocusLost(evt);
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
        tfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNomeKeyTyped(evt);
            }
        });

        tfUF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfUF.setForeground(new java.awt.Color(153, 153, 153));
        tfUF.setText("Digite o UF...");
        tfUF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfUFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfUFFocusLost(evt);
            }
        });

        tfCNPJ.setForeground(new java.awt.Color(153, 153, 153));
        tfCNPJ.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        tfCEP.setForeground(new java.awt.Color(153, 153, 153));
        tfCEP.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout back3Layout = new javax.swing.GroupLayout(back3);
        back3.setLayout(back3Layout);
        back3Layout.setHorizontalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back3Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addGroup(back3Layout.createSequentialGroup()
                        .addComponent(btn_Criar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Alterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Inativar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back3Layout.createSequentialGroup()
                        .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBairro)
                            .addComponent(tfNome)
                            .addComponent(tfCEP))
                        .addGap(85, 85, 85)
                        .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCidade)
                            .addComponent(tfEnd)
                            .addComponent(tfCNPJ))))
                .addGap(170, 170, 170))
            .addGroup(back3Layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        back3Layout.setVerticalGroup(
            back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(tfCNPJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(tfCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Criar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Inativar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, back2Layout.createSequentialGroup()
                .addGroup(back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(back2Layout.createSequentialGroup()
                        .addGap(0, 153, Short.MAX_VALUE)
                        .addGroup(back2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_home, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btn_Cond_In.setBackground(new java.awt.Color(51, 121, 241));
        btn_Cond_In.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Cond_In.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cond_In.setText("<html> \n<center> \nCondomínios <br/> Inativados\n</center>\n</html>\n");
        btn_Cond_In.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cond_InActionPerformed(evt);
            }
        });

        btn_Gerenc_Cond.setBackground(new java.awt.Color(0, 53, 143));
        btn_Gerenc_Cond.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Gerenc_Cond.setForeground(new java.awt.Color(255, 255, 255));
        btn_Gerenc_Cond.setText("<html>  \n<center>  \nGerenciamento <br/> de Condomínios \n</center> \n</html>");
        btn_Gerenc_Cond.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Gerenc_CondActionPerformed(evt);
            }
        });

        btn_Geren_Port.setBackground(new java.awt.Color(51, 121, 241));
        btn_Geren_Port.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Geren_Port.setForeground(new java.awt.Color(255, 255, 255));
        btn_Geren_Port.setText("<html>  \n<center>  \nGerenciamento <br/> dos Porteiros \n</center> \n</html>");
        btn_Geren_Port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Geren_PortActionPerformed(evt);
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
            .addGroup(back1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Geren_Port, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Gerenc_Cond, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cond_In, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Port_In, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(back3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(back2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        back1Layout.setVerticalGroup(
            back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(back1Layout.createSequentialGroup()
                .addComponent(back2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(back1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(back1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btn_Gerenc_Cond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_Geren_Port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btn_Cond_In, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btn_Port_In, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addComponent(back3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    private void btn_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AlterarActionPerformed
        String nome = tfNome.getText();
        String cnpj = tfCNPJ.getText();
        String cep = tfCEP.getText();
        String endereco = tfEnd.getText();
        String bairro = tfBairro.getText();
        String cidade = tfCidade.getText();
        String uf = tfUF.getText();
        String sql= "";
        String msg= "";
        
        if("Digite o Nome...".equals(nome) || "Digite o CNPJ...".equals(cnpj) || "Digite o CEP...".equals(cep) || "Digite o Endereço...".equals(endereco) || "Digite o Bairro...".equals(bairro) || "Digite a Cidade...".equals(cidade) || "Digite o UF...".equals(uf))
        {
               JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos solicitados!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
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

                if(rs.next())
                {
                    sql = "UPDATE condominio set nome_condominio='" + nome + "',cnpj='" + cnpj + "',cep='" + cep + "',endereco='" + endereco  + "',bairro='" + bairro + "',cidade='" + cidade + "',uf='" + uf + "' where id_condominio = " + getIdCondominioSelecionado();
                    msg = "Alteração de registro";

                }
                ps.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, msg + " realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

                ps = con.prepareStatement("SELECT * FROM condominio WHERE situacao = 'ativo' ORDER BY id_condominio");
                rs = ps.executeQuery();
                rs.first();
                preencherTabela();
                limparCampos();
                btn_Alterar.setEnabled(false);
                btn_Inativar.setEnabled(false);
                btn_Criar.setEnabled(true);
            }
            catch(SQLException errosql)
            {
                JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_AlterarActionPerformed

    private void btn_Gerenc_CondActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Gerenc_CondActionPerformed
        frm_gerenc_condominio mostra = new frm_gerenc_condominio();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_Gerenc_CondActionPerformed

    private void btn_Geren_PortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Geren_PortActionPerformed
        String tipoTelaPort = "ativos";
        frm_pre_gporteiros mostra = new frm_pre_gporteiros(tipoTelaPort);
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_Geren_PortActionPerformed

    private void btn_Port_InActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Port_InActionPerformed
        String tipoTelaPort = "inativos";
        frm_pre_gporteiros mostra = new frm_pre_gporteiros(tipoTelaPort);
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_Port_InActionPerformed

    private void btn_Cond_InActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cond_InActionPerformed
        frm_cond_inativos mostra = new frm_cond_inativos();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_Cond_InActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        login mostra = new login();
        mostra.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void tfNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusGained
        if(tfNome.getText().equals("Digite o Nome..."))
        {
            tfNome.setText("");
            tfNome.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfNomeFocusGained

    private void tfNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeFocusLost
        if(tfNome.getText().equals(""))
        {
            tfNome.setText("Digite o Nome...");
            tfNome.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_tfNomeFocusLost

    private void tfEndFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEndFocusGained
        if(tfEnd.getText().equals("Digite o Endereço..."))
        {
            tfEnd.setText("");
            tfEnd.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfEndFocusGained

    private void tfEndFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEndFocusLost
        if(tfEnd.getText().equals(""))
        {
            tfEnd.setText("Digite o Endereço...");
            tfEnd.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_tfEndFocusLost

    private void tfBairroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBairroFocusGained
        if(tfBairro.getText().equals("Digite o Bairro..."))
        {
            tfBairro.setText("");
            tfBairro.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfBairroFocusGained

    private void tfBairroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBairroFocusLost
        if(tfBairro.getText().equals(""))
        {
            tfBairro.setText("Digite o Bairro...");
            tfBairro.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_tfBairroFocusLost

    private void tfCidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCidadeFocusGained
        if(tfCidade.getText().equals("Digite a Cidade..."))
        {
            tfCidade.setText("");
            tfCidade.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfCidadeFocusGained

    private void tfCidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCidadeFocusLost
        if(tfCidade.getText().equals(""))
        {
            tfCidade.setText("Digite a Cidade...");
            tfCidade.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_tfCidadeFocusLost

    private void tfUFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUFFocusGained
        if(tfUF.getText().equals("Digite o UF..."))
        {
            tfUF.setText("");
            tfUF.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_tfUFFocusGained

    private void tfUFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfUFFocusLost
        if(tfUF.getText().equals(""))
        {
            tfUF.setText("Digite o UF...");
            tfUF.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_tfUFFocusLost

    private void btn_CriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CriarActionPerformed
        String nome = tfNome.getText();
        String cnpj = tfCNPJ.getText();
        String cep = tfCEP.getText();
        String endereco = tfEnd.getText();
        String bairro = tfBairro.getText();
        String cidade = tfCidade.getText();
        String uf = tfUF.getText();
        
        if("Digite o Nome...".equals(nome) || "Digite o CNPJ...".equals(cnpj) || "Digite o CEP...".equals(cep) || "Digite o Endereço...".equals(endereco) || "Digite o Bairro...".equals(bairro) || "Digite a Cidade...".equals(cidade) || "Digite o UF...".equals(uf))
           {
               JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos solicitados!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
           }else{
            if(ValidadorCNPJ.validarCNPJ(cnpj))
            {                        
                try
                {
                    String insert_sql="INSERT into condominio (nome_condominio,cnpj,cep,endereco,bairro,cidade,uf) values ('" + nome + "','" + cnpj + "','" + cep + "','" + endereco  + "','" + bairro + "','" + cidade + "','" + uf + "')";
                    ps.executeUpdate(insert_sql);
                    JOptionPane.showMessageDialog(null, "Gravação Realizada com sucesso!!!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);


                    ps = con.prepareStatement("SELECT * FROM condominio WHERE situacao = 'ativo' ORDER BY id_condominio");
                    rs = ps.executeQuery();
                    rs.first();
                    preencherTabela();
                    limparCampos();
                }
                catch(SQLException errosql)
                {
                    JOptionPane.showMessageDialog(null, "\n Erro ao gravar os dados ", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }             
            }
            else
            {
                        JOptionPane.showMessageDialog(null, "CNPJ Inválido! \nPor favor, verifique novamente o campo inserido...", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
                        tfCNPJ.requestFocus();
            }
        }
        
    }//GEN-LAST:event_btn_CriarActionPerformed

    private void tbl_Cond_AtvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Cond_AtvMouseClicked
        btn_Criar.setEnabled(false);
        btn_Alterar.setEnabled(true);
        btn_Inativar.setEnabled(true);
        int linha_selecionada = tbl_Cond_Atv.getSelectedRow();
        tfNome.setText(tbl_Cond_Atv.getValueAt(linha_selecionada, 0).toString());
        tfNome.setForeground(new Color(0,0,0));
        tfCNPJ.setText(tbl_Cond_Atv.getValueAt(linha_selecionada, 1).toString());
        tfCNPJ.setForeground(new Color(0,0,0));
        tfCEP.setText(tbl_Cond_Atv.getValueAt(linha_selecionada, 2).toString());
        tfCEP.setForeground(new Color(0,0,0));
        tfEnd.setText(tbl_Cond_Atv.getValueAt(linha_selecionada, 3).toString());
        tfEnd.setForeground(new Color(0,0,0));
        tfBairro.setText(tbl_Cond_Atv.getValueAt(linha_selecionada, 4).toString());
        tfBairro.setForeground(new Color(0,0,0));
        tfCidade.setText(tbl_Cond_Atv.getValueAt(linha_selecionada, 5).toString());
        tfCidade.setForeground(new Color(0,0,0));
        tfUF.setText(tbl_Cond_Atv.getValueAt(linha_selecionada, 6).toString());
        tfUF.setForeground(new Color(0,0,0));
        
        String cnpj = tfCNPJ.getText();
        
        // Executando uma consulta para obter o ID do morador com base no nome e número do apartamento:
        try {
            String pesquisaIdMorador = "SELECT id_condominio FROM condominio WHERE cnpj = ?";
            ps = con.prepareStatement(pesquisaIdMorador);
            ps.setString(1, cnpj);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                int idCond = rs.getInt("id_condominio");
                setIdCondominioSelecionado(idCond);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível obter os dados requisitados!", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tbl_Cond_AtvMouseClicked

    private void btn_InativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InativarActionPerformed
        String cnpj = tfCNPJ.getText();
        String situacao = "inativo";
        
        String sql= "";
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
            
            if(rs.next())
            {
                int realId = rs.getInt("id_condominio");
                
                sql = "UPDATE condominio set situacao='" + situacao + "' where id_condominio = " + realId;
                msg = "Inativação de registro";
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Não é possível alterar um registro não existente! ", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
            }
            ps.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, msg + " realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            
            ps = con.prepareStatement("SELECT * FROM condominio WHERE situacao = 'ativo' ORDER BY id_condominio");
            rs = ps.executeQuery();
            rs.first();
            preencherTabela();
            limparCampos();
            btn_Alterar.setEnabled(false);
            btn_Inativar.setEnabled(false);
            btn_Criar.setEnabled(true);
        }
        catch(SQLException errosql)
        {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btn_InativarActionPerformed

    private void tfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeKeyTyped

    }//GEN-LAST:event_tfNomeKeyTyped

    private void logo(){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/logo/SRs.png"));
        Image scaleImage = imageIcon.getImage().getScaledInstance(170, 170,Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(scaleImage);
        lblLogo.setIcon(img);
    }
    
    //Esse método chama os componentes da tabela do banco, e os coloca no jtable:
    private void preencherTabela(){
        tbl_Cond_Atv.getColumnModel().getColumn(0).setPreferredWidth(120);
        tbl_Cond_Atv.getColumnModel().getColumn(1).setPreferredWidth(60);
        tbl_Cond_Atv.getColumnModel().getColumn(2).setPreferredWidth(60);
        tbl_Cond_Atv.getColumnModel().getColumn(3).setPreferredWidth(60);
        tbl_Cond_Atv.getColumnModel().getColumn(4).setPreferredWidth(60);
        tbl_Cond_Atv.getColumnModel().getColumn(5).setPreferredWidth(60);
        tbl_Cond_Atv.getColumnModel().getColumn(6).setPreferredWidth(4);
        
        DefaultTableModel modelo = (DefaultTableModel) tbl_Cond_Atv.getModel();
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
    
    private void limparCampos(){
        tfNome.setText("Digite o Nome...");
        tfNome.setForeground(new Color(153,153,153));
        tfCNPJ.setText("Digite o CNPJ...");
        tfCNPJ.setForeground(new Color(153,153,153));
        tfCEP.setText("Digite o CEP...");
        tfCEP.setForeground(new Color(153,153,153));
        tfEnd.setText("Digite o Endereço...");
        tfEnd.setForeground(new Color(153,153,153));
        tfBairro.setText("Digite o Bairro...");
        tfBairro.setForeground(new Color(153,153,153));
        tfCidade.setText("Digite a Cidade...");
        tfCidade.setForeground(new Color(153,153,153));
        tfUF.setText("Digite o UF...");
        tfUF.setForeground(new Color(153,153,153));
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back1;
    private javax.swing.JPanel back2;
    private javax.swing.JPanel back3;
    private javax.swing.JButton btn_Alterar;
    private javax.swing.JButton btn_Cond_In;
    private javax.swing.JButton btn_Criar;
    private javax.swing.JButton btn_Geren_Port;
    private javax.swing.JButton btn_Gerenc_Cond;
    private javax.swing.JButton btn_Inativar;
    private javax.swing.JButton btn_Port_In;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_home;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JTable tbl_Cond_Atv;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JFormattedTextField tfCNPJ;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfEnd;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfUF;
    // End of variables declaration//GEN-END:variables
}
