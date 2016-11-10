package br.com.projetusit.teste.anagram;

import br.com.projetusit.teste.entity.Word;

import java.util.List;

/**
 * Representa um anagrama. Com ele é possível determinar sua classe
 * e as palavras do texto que correspondem a sua classe.
 * User: Brandao.
 * Date: 10/10/15
 * Time: 15:17
 */
public class Anagram {

    /**
     * Classe do anagrama.
     */
    private AnagramClass type;

    /**
     * Palavras pertencentes a classe do anagrama.
     */
    private List<Word> words;

    /**
     * Cria uma nova instância de um anagrama sem uma classe definida.
     */
    public Anagram() {
    }

    /**
     * Cria uma instância de uma anagrama.
     * @param type Classe do anagrama.
     * @param words Palavras que pertencem a classe do anagrama.
     */
    public Anagram(AnagramClass type, List<Word> words) {
        this.type = type;
        this.words = words;
    }

    /**
     * Obtém a classe do anagrama.
     * @return Classe.
     */
    public AnagramClass getType() {
        return type;
    }

    /**
     * Define a classe do anagrama.
     * @param type Classe.
     */
    public void setType(AnagramClass type) {
        this.type = type;
    }

    /**
     * Obtém a lista de palagras que pertencem ao anagrama.
     * @return Lista de palavras.
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * Define a lista de palagras que pertencem ao anagrama.
     * @param words Lista de palavras.
     */
    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Anagram that = (Anagram) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }
}
