package br.com.projetusit.teste.parser;

import br.com.projetusit.teste.anagram.AnagramClass;
import br.com.projetusit.teste.entity.Word;
import br.com.projetusit.teste.io.TextReader;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Converte um determinado texto em palavras.
 * User: Brandao.
 * Date: 10/10/15
 * Time: 13:12
 */
public class WordParser {

    /**
     * Delimitadores, em formato de texto, usados para destacar as palavras do texto.
     */
    private static final String DELIMITER      = " ,.";

    /**
     * Delimitadores, em arranjo de caracteres, usados para destacar as palavras do texto.
     */
    private static final char[] DELIMITER_CHARS = DELIMITER.toCharArray();

    /**
     * Mapa contendo os filtros usados no tratamento do texto.
     */
    private static final Map<String,Pattern> DELIMITER_FILTER;

    static{
        //Inicia o mapa.
        DELIMITER_FILTER = new HashMap<String, Pattern>();

        //Gera um filtro para cada delimitador.
        for(char c: DELIMITER_CHARS){
            Pattern p = Pattern.compile("(\\" + c + ")+");
            DELIMITER_FILTER
                .put(String.valueOf(c), p);
        }

        //Adiciona um filtro para o delimitador \r
        DELIMITER_FILTER
                .put("", Pattern.compile("\\r+"));

    }

    /**
     * Lê o texto de um determinado arquivo e o converte em palavras.
     * @param reader Leitor do arquivo.
     * @return Lista de palavras.
     * @throws IOException Lançada caso ocorra um problema ao obter o
     * texto do arquivo.
     */
    public List<Word> parse(TextReader reader) throws IOException{
        //Lê o texto e o agrupa em linhas.
        List<String> lines = reader.read();

        //Inicia o container onde os fragmentos serão inseridos.
        //Os fragmentos repetidos serão ignorados.
        Set<Word> result   = new HashSet<Word>();

        //Fragmenta o texto e os converte em palavras.
        for(String line: lines){
            //Fragmenta o texto.
            List<String> words = this.getWords(line);
            //Converte os fragmentos em palavras e os insere no container.
            result.addAll(this.toWords(words));
        }

        //Transfere as palavras do container para uma lista.
        return new ArrayList<Word>(result);
    }

    /**
     * Converte uma lista de fragmento de texto sem delimitadores em palavras.
     * @param words Fragmentos.
     * @return Palavras.
     */
    private List<Word> toWords(List<String> words){

        //Inicia a lista que conterá as palavras.
        List<Word> result = new ArrayList<Word>();

        //Preenche a lista com as palavras.
        for(String w: words){
            result.add(
                    new Word(
                        w,                          //O nome da palavra é ela mesma.
                        AnagramClass.getClass(w))); //Define a classe de anagrama da palavra.
        }

        return result;
    }

    /**
     * Fragmenta um texto de acordo com os delimitadores
     * {@link br.com.projetusit.teste.parser.WordParser#DELIMITER_CHARS}.
     * @param line Texto.
     * @return Fragmentos.
     */
    private List<String> getWords(String line){

        //Prepara o texto para ser fragmentado.
        line = this.prepareLineToTokenizer(line);

        //Inicia o fragmentador do texto o configurando com os delimitadores.
        StringTokenizer tokenizer = new StringTokenizer(line, DELIMITER);

        //Inicia a lista que conterá os fragmentos.
        List<String> result = new ArrayList<String>();

        //Preenche a lista com os fragmentos.
        while(tokenizer.hasMoreElements()){
            result.add(tokenizer.nextToken());
        }

        return result;
    }

    /**
     * Prepara um determinado texto para ser fragmentado.
     * @param line Texto.
     * @return Texto tratado.
     */
    private String prepareLineToTokenizer(String line){

        //Inicia o construtor do texto tratado com um
        //texto todo em minúsculo
        StringBuilder result = new StringBuilder(line.toLowerCase());

        //Remove delimitadores duplicados usando regex.
        //ex: converte "..." em "."
        for(String c: DELIMITER_FILTER.keySet()){

            Pattern pattern = DELIMITER_FILTER.get(c);
            Matcher m = pattern.matcher(result);
            StringBuffer sb = new StringBuffer();

            while (m.find())
                m.appendReplacement(sb, c);

            m.appendTail(sb);
            result.setLength(0);
            result.append(sb);

        }

        //Gera o texto tratado a partir do seu construtor.
        return result.toString();
    }
}
