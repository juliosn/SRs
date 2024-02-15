package conexao;


import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author Júlio e Maria
 */

public class Conexao {
    /*final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://127.0.0.1/srs_database";
    final private String usuario = "root";
    final private String senha = "";
    public static Connection conexao;
    public static Statement statement;
    public static ResultSet resultset;*/
    
    
    public static Connection conecta(){

        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1/srs_database?useUnicode=true&characterEncoding=UTF-8", "root","");        
        } catch (ClassNotFoundException Driver){
            JOptionPane.showMessageDialog(null, "Driver não localizado.", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            
        }catch (SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Fonte de dados não localizada.", "Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
            
        }
        return conexao;
    }
}
