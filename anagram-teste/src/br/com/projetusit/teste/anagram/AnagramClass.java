package br.com.projetusit.teste.anagram;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Representa uma classe de anagrama.
 * User: Brandao.
 * Date: 10/10/15
 * Time: 12:11
 */
public final class AnagramClass {

    /**
     * Identificação da classe.
     * A identificação segue o formato: (&lt;c&gt;[&lt;q&gt;])+.
     * Onde:
     * c é o caracter e
     * q é a frequência do mesmo.
     * ex: A palavra "aax" teria uma classe de anagrama com
     * a identificação "a[2]x[1]"
     */
    private final String id;

    /**
     * Nome da classe do anagrama.
     * O nome segue o formato (&lt;c&gt;)+.
     * Onde:
     * c é o caracter e.
     * ex: A palavra "aax" teria uma classe de anagrama com
     * o nome "ax"
     */
    private final String name;

    /**
     * Cria uma nova classe de anagrama.
     * @param id Identificação do anagrama.
     * @param name Nome do anagrama.
     */
    private AnagramClass(String id, String name){
        this.id   = id;
        this.name = name;
    }

    /**
     * Obtém a identificação do anagrama.
     * @return Identificação.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtém o nome do anagrama.
     * @return Nome.
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnagramClass that = (AnagramClass) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * Mapa contendo todas as classes de anagrama da aplicação.
     */
    private static final ConcurrentMap<String, AnagramClass> anagrams;

    static{
        //Inicializa o mapa de anagramas da aplicação.
        anagrams = new ConcurrentHashMap<String, AnagramClass>();
    }

    /**
     * Obtém uma classe de anagrama a partir de uma palavra.
     * @param value Palavra.
     * @return Classe de anagrama.
     */
    public static AnagramClass getClass(String value){

        //Obtém os caracteres, sem duplicidade, do texto.
        Character[] data = Util.getUniqueChars(value);
        //Obtém a frequência dos caracteres.
        Map<Character,Integer> counts = Util.countChars(value);

        //Construtor da identificação da classe.
        StringBuilder builderID   = new StringBuilder();
        //Construtor do nome da classe.
        StringBuilder builderName = new StringBuilder();

        //Constrói o nome e a identificação.
        for(Character c: data){
            Integer count = counts.get(c);
            builderName.append(c);
            builderID
                    .append(c)
                    .append("[")
                    .append(count)
                    .append("]");
        }

        //Gera a identificação da classe.
        String id   = builderID.toString();
        //Gera o nome da classe.
        String name = builderName.toString();

        //Trecho de código sincronizado para
        //evitar multiplas instâncias de uma classe.
        synchronized(anagrams){
            //Tenta obter a classe.
            AnagramClass type = anagrams.get(id);

            //Se a classe ainda não existir, ela será registrada.
            if(type == null){
                type = new AnagramClass(id, name);
                anagrams.put(id,type);
            }

            return type;
        }

    }

}
