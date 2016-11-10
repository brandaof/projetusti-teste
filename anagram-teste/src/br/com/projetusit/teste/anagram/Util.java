package br.com.projetusit.teste.anagram;

import br.com.projetusit.teste.entity.Word;

import java.util.*;

/**
 * Utilitário contendo métodos que auxiliam a manipulação de anagramas.
 * User: Brandao.
 * Date: 10/10/15
 * Time: 14:43
 */
public final class Util {

    /**
     * Converte uma palavra em um arranjo de caracteres não repetidos.
     * @param value Palavra.
     * @return Arranjo de caracteres.
     */
    public static Character[] getUniqueChars(String value){

        //Inicia o container onde os caracteres serão inseridos.
        //Os caracteres repetidos serão ignorados.
        Set<Character> result = new HashSet<Character>();

        //Insere os caracteres no container.
        for(char c: value.toCharArray()){
            result.add(c);
        }

        //Converte o container em um arranjo de caracteres.
        Character[] array = result.toArray(new Character[]{});

        //Ordena os caracteres em ordem alfabética.
        Arrays.sort(array);

        return array;
    }

    /**
     * Obtém um mapa contento a frequência com que os caracteres
     * aparecem em um determinado fragmento de texto.
     * @param value Fragmento.
     * @return Mapa.
     */
    public static Map<Character,Integer> countChars(String value){

        //Inicia o mapa que irá conter as frequências.
        Map<Character,Integer> result = new HashMap<Character, Integer>();

        //Varre o texto para se determinar a frequência dos caracteres.
        for(char c: value.toCharArray()){

            //Tenta obter a frequência de um determinado caracter.
            Integer count = result.get(c);

            //Se não existir, ele será iniciado em 1.
            //Se já existir, será adicionado 1 a frequência.
            if(count == null)
                count = 1;
            else
                count++;

            //Armazena a frequência.
            result.put(c, count);
        }

        return result;
    }

    /**
     * Rearranja uma coleção de palavras em anagramas.
     * @param value Coleção.
     * @return Anagramas.
     */
    public static List<Anagram> getAnagram(List<Word> value){
        //Mapa que irá conter o agrupamento de palavras por classe de anagrama.
        Map<AnagramClass,List<Word>> map =
                new HashMap<AnagramClass, List<Word>>();

        //Varre a lista de palavras para fazer o agrupamento.
        for(Word w: value){
            //Tenta obter o agrupamento de uma determinada palavra.
            List<Word> list = map.get(w.getType());

            //Se não existir o agrupamento, ele será criado e armazenado no mapa.
            if(list == null){
                list = new ArrayList<Word>();
                map.put(w.getType(), list);
            }

            //Insere a palavra no agrupamento.
            list.add(w);
        }

        //Lista contendo os anagramas.
        List<Anagram> result = new ArrayList<Anagram>();

        //Varre o agrupamento de palavras para se criar o anagrama.
        for(AnagramClass type: map.keySet()){

            //Obtém o grupo de palavras.
            List<Word> list = map.get(type);

            //Se no agrupamento existir mais de uma palavra,
            // será criado o anagrama da classe. Caso contrário,
            // o agrupamento será ignorado.
            if(list.size() > 1){
                orderWordByName(list);
                result.add(new Anagram(type, list));
            }
        }

        //Ordena os anagrams pelo nome de sua classe.
        orderAnagramByName(result);

        return result;
    }

    /**
     * Ordena uma coleção de palavras por ordem alfabética.
     * @param values Coleção.
     */
    private static void orderWordByName(List<Word> values){
        Collections.sort(
                values, new Comparator<Word>() {
            @Override
            public int compare(Word word, Word word1) {
                return word.getName().compareTo(word1.getName());
            }
        });
    }

    /**
     * Ordena uma coleção de anagramas pelo nome de sua classe.
     * @param values Anagramas.
     */
    private static void orderAnagramByName(List<Anagram> values){
        Collections.sort(
                values, new Comparator<Anagram>() {
            @Override
            public int compare(Anagram a, Anagram a1) {
                return a.getType().getName()
                        .compareTo(a1.getType().getName());
            }
        });
    }
    
}
