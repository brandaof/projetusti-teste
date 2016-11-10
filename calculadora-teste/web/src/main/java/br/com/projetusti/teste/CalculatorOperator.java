package br.com.projetusti.teste;

import java.math.BigDecimal;

/**
 * Representa uma operação matemática.
 * @author Brandao
 * @since 11/10/2015
 * @version 1.0.0
 */
public interface CalculatorOperator {

    /**
     * Aplica uma operação matemática entre dois números.
     * @param n1 Primeiro número.
     * @param n2 Segundo número.
     * @return Resultado da operação.
     * @throws CalculatorException Lançada se ocorrer alguma falha ao tentar fazer
     * a operação matemática.
     */
    Number apply(Number n1, Number n2) throws CalculatorException;

}
