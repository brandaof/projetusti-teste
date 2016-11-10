package br.com.projetusti.teste;

/**
 * Lançada caso ocorra uma falha no calculo da expressão numérica.
 * @author Brandao
 * @since 11/10/2015
 * @version 1.0.0
 */
public class CalculatorException
        extends Exception {

    public CalculatorException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }

    public CalculatorException(Throwable throwable) {
        super(throwable);
    }

    public CalculatorException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public CalculatorException(String s) {
        super(s);
    }

    public CalculatorException() {
    }
}
