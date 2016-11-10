package br.com.projetusit.teste;

import br.com.projetusit.teste.anagram.Anagram;
import br.com.projetusit.teste.anagram.Util;
import br.com.projetusit.teste.entity.Word;
import br.com.projetusit.teste.io.AnagramWriter;
import br.com.projetusit.teste.io.TextReader;
import br.com.projetusit.teste.parser.WordParser;

import java.io.IOException;
import java.util.List;

/**
 * Converte um arquivo de texto em um
 * arquivo contendo uma lista de anagramas.
 * User: Brandao
 * Date: 10/10/15
 * Time: 15:37
 */
public class AnagramProcess {

    public static void convert(String originFileName,
                               String destFileName) throws IOException {
        //Inicia o leitor do texto.
        TextReader reader = new TextReader(originFileName);
        //Inicia o escritor dos anagramas.
        AnagramWriter writer =
                new AnagramWriter(destFileName);

        //Inicia o analisador de palavras.
        WordParser parser = new WordParser();

        //Converte o texto bruto em palavras.
        List<Word> words = parser.parse(reader);

        //Converte as palavras em anagramas.
        List<Anagram> anagrams = Util.getAnagram(words);

        //Registra os anagramas em disco.
        writer.write(anagrams);

    }

}
