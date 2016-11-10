package br.com.projetusit.teste;

/**
 * Componente principal da aplicação. É a fronteira
 * entre o sistema e o cliente.
 *
 * User: Brandao
 * Date: 10/10/15
 * Time: 15:37
 */
public class Main {

    /**
     * Método que inicia a aplicação.
     * @param args Parâmetros recebidos.
     * @throws Throwable Lançada se ocorrer algum erro na aplicação.
     */

    public static void main(String[] args) throws Throwable{
        AnagramProcess.convert("teste.txt", "anagramas.txt");
    }

}
