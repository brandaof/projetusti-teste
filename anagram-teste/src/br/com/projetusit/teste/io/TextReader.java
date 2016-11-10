package br.com.projetusit.teste.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;

/**
 * Faz a leitura de dados de um arquivo texto. Ele permite definir a
 * codificação do texto que será lido.
 * User: Brandao.
 * Date: 10/10/15
 * Time: 12:28
 */
public class TextReader {
    
    private String fileName;
    
    private Charset encode;

    /**
     * Cria uma nova instância.
     * @param fileName Nome do arquivo.
     */
    public TextReader(String fileName){
        this(fileName, Charset.defaultCharset());
    }

    /**
     * Cria uma nova instância.
     * @param fileName Nome do arquivo.
     * @param encode Codificação do texto.
     */

    public TextReader(String fileName, Charset encode){
        this.fileName = fileName;
        this.encode   = encode;
    }

    /**
     * Lê os dados de um arquivo e os agrupa em linhas.
     * @return Linhas.
     * @throws IOException Lançada caso ocorra uma falha ao ler o arquivo.
     */
    public List<String> read() throws IOException{
        Path path = Paths.get(this.fileName);
        return Files.readAllLines(path, this.encode);
    }

}
