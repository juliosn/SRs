//Declaração de pacote:
package validacao;

//Importação de classes:
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Júlio, Maria e Victor
 */

//Classe pública ViaCEP:
public class ViaCEP {
    
    //Método consultarCEP, que irá buscar os dados do condomínio relacionados ao CEP (endereço, bairro, cidade e uf):
    public static String consultarCEP(String cep) throws Exception {
        //Declarando url da API via cep + valor do cep que será utilizado:
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        
        //Armazenando objetos de conexão e requisições http:
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        
        //Armazenando resposta da conexão:
        int responseCode = con.getResponseCode();
        
        //Caso ela tenha funcionado, serão armazenados os valores relacionados ao cep:
        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            
            return response.toString();
        } else{
            throw new Exception("Não foi possível consultar o CEP. Código de resposta: " + responseCode);
        }
    }
    
}
