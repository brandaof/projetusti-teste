package br.com.projetusit.teste.entity;

import br.com.projetusit.teste.anagram.AnagramClass;

/**
 * Representa uma palavra. Com ele é possível determinar
 * seu nome a qual classe de anagrama ela pertence.
 * User: Brandao
 * Date: 10/10/15
 * Time: 13:29
 */
public class Word {
    
    private String name;
    
    private AnagramClass type;

    /**
     * Cria uma nova instância.
     * @param name Nome da palavra.
     * @param type Classe da palavra.
     */
    public Word(String name, AnagramClass type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Obtém a classe da palavra.
     * @return Classe.
     */
    public AnagramClass getType() {
        return type;
    }

    /**
     * Define a classe da palavra.
     * @param type Classe.
     */
    public void setType(AnagramClass type) {
        this.type = type;
    }

    /**
     * Obtém o nome da palavra.
     * @return Nome
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da palavra.
     * @param name Nome.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (name != null ? !name.equals(word.name) : word.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
