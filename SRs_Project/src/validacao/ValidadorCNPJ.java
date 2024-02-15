//Declarando pacote:
package validacao;

/**
 *
 * @author Julio, Maria e Victor
 */


//Classe pública 'ValidadorCNPJ':
public class ValidadorCNPJ {
    
    
    //Método de validação de CNPJ:
    public static boolean validarCNPJ(String cnpj) 
    {
        // Remove caracteres não numéricos do CNPJ:
        cnpj = cnpj.replaceAll("[^0-9]", "");

        // Verifica se o CNPJ possui 14 dígitos após a remoção de caracteres não numéricos:
        if (cnpj.length() != 14) {
            return false;
        }

        // Calculando o primeiro dígito verificador:
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }

        int resto = soma % 11;
        int primeiroDigitoVerificador = (resto < 2) ? 0 : (11 - resto);

        // Calculando o segundo dígito verificador
        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma += digito * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }

        resto = soma % 11;
        int segundoDigitoVerificador = (resto < 2) ? 0 : (11 - resto);

        // Verifica se os dígitos verificadores calculados são iguais aos do CNPJ original
        return (Character.getNumericValue(cnpj.charAt(12)) == primeiroDigitoVerificador)
                && (Character.getNumericValue(cnpj.charAt(13)) == segundoDigitoVerificador);
    }
}
