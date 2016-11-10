package br.com.projetusti.teste.calculator {

import br.com.projetusti.teste.remote.*;

/**
 * Classe que integra o serviço da calculadora.
 * @author Brandao
 * @since 11/10/2015
 * @version 1.0.0
 */

public class CalculatorControllerImp
    extends GenericRemoteObject
    implements CalculatorController{

    /**
     * Cria uma nova instância configurando o serviço.
     */
    public function CalculatorControllerImp() {
        super();
        this.destination = "calculatorService";
    }


    /**
     * Prepara a ação de calcular. O calculo será feito no momento
     *  que {br.com.projetusti.teste.calculatorController.Invoker#invoke} for executado.
     * @param n1 Primeiro número.
     * @param n2 Segundo número.
     * @param operator Operador matemático
     * @return
     */
    public function calculate(n1:Number, n2:Number, operator:String):Invoker{
        return new Invoker("calculate", [n1,n2,operator], this);
    }

}
}
