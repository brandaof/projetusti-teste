package br.com.projetusti.teste;

/**
 * Serviço da calculadora. Ele ficará exposto para que o front-end o consuma.
 *
 * @author Brandao
 * @since 11/10/2015
 * @version 1.0.0
 */
public class CalculatorService {

    /**
     * Calcula uma expressão numérica que contém dois números.
     * @param n1 Primeiro número da expressão.
     * @param n2 Segundo número da expressão.
     * @param operator Operador matemático. Os valores estão descritos em (CalculatorOperators).
     * @return Resultado da expressão numérica.
     */
    public Number calculate(Number n1,
                        Number n2, String operator) throws CalculatorException {
        return this.calculate(n1, n2, CalculatorOperators.valueOf(operator.toUpperCase()));
    }

    /**
     * Calcula uma expressão numérica que contém dois números.
     * @param n1 Primeiro número da expressão.
     * @param n2 Segundo número da expressão.
     * @param operator Operador matemático. Os valores estão descritos em (CalculatorOperators).
     * @return Resultado da expressão numérica.
     */
    private Number calculate(Number n1, Number n2,
                        CalculatorOperators operator) throws CalculatorException {
        return operator.apply(n1, n2);
    }

}
