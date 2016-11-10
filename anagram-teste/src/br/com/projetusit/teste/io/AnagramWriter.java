package br.com.projetusit.teste.io;

import br.com.projetusit.teste.anagram.Anagram;
import br.com.projetusit.teste.entity.Word;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Faz a persistência de um conjunto de anagrama em disco.
 * User: Brandao
 * Date: 10/10/15
 * Time: 12:30
 */
public class AnagramWriter {

    private String fileName;

    private Charset encode;

    /**
     * Cria uma nova instância.
     * @param fileName Nome do arquivo.
     */
    public AnagramWriter(String fileName){
        this(fileName, Charset.defaultCharset());
    }

    /**
     * Cria uma nova instância.
     * @param fileName Nome do arquivo.
     * @param encode Codificação do texto.
     */
    public AnagramWriter(String fileName, Charset encode){
        this.fileName = fileName;
        this.encode   = encode;
    }

    /**
     * Faz a persistência de uma lista de anagramas.
     * @param anagramas Lista.
     * @throws IOException Lançada caso ocorra uma falha na persistência.
     */
    public void write(List<Anagram> anagramas)throws IOException{

        //Inicia o container onde as linhas
        // do arquivo serão armazenadas.
        List<String> lines = new ArrayList<String>();

        //Insere a quantidade de anagramas.
        lines.add(String.valueOf(anagramas.size()));

        //Varre a lista de anagramas para os registrar no container.
        for(Anagram group: anagramas){
            //Construtor da linha do anagrama.
            StringBuilder line = new StringBuilder();

            //Varre a lista de palavras do anagrama para os inserir
            // em sua respectiva linha.
            for(Word w: group.getWords()){
                //Se a linha não estiver vazia, inserir um espaço antes da nova palavra.
                if(line.length() > 0)
                    line.append(" ");

                //Insere uma palavra.
                line.append(w.getName());
            }

            //Gera a linha do anagrama.
            lines.add(line.toString());
        }

        //Grava as linhas em disco.
        Path path = Paths.get(this.fileName);
        Files.write(path, lines, this.encode);
    }

}
