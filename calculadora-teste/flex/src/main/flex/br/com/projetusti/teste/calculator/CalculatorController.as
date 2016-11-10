package br.com.projetusti.teste.calculator {

import br.com.projetusti.teste.remote.Invoker;

/**
 * Controlador responsável pela calculadora.
 * @author Brandao.
 * @since 11/10/2015
 * @version 1.0.0
 */

public interface CalculatorController {

    /**
     * Calcula uma expressão numérica que contém dois números.
     * @param n1 Primeiro número da expressão.
     * @param n2 Segundo número da expressão.
     * @param operator Operador matemático. Os valores estão descritos em (CalculatorOperators).
     * @return Executor da expressão numérica.
     */
    function calculate(n1:Number, n2:Number, operator:String):Invoker;

}


}
