package br.com.projetusti.teste;

import java.math.BigDecimal;

/**
 * Descreve as operações matemáticas da calculadora.
 * @author Brandao.
 * @since 11/10/2015
 * @version 1.0.0
 */
public enum CalculatorOperators
            implements CalculatorOperator {

    /**
     * Soma.
     */
    SUM{

        public Number apply(Number n1, Number n2) throws CalculatorException{
            return n1.doubleValue() + n2.doubleValue();
        }

    },

    /**
     * Subtração.
     */
    SUBTRACT{

        public Number apply(Number n1, Number n2) throws CalculatorException{
            return n1.doubleValue() - n2.doubleValue();
        }

    },

    /**
     * Multiplicação.
     */
    MULTIPLY{

        public Number apply(Number n1, Number n2) throws CalculatorException{
            return n1.doubleValue()*n2.doubleValue();
        }

    },

    /**
     * Divisão.
     */
    DIVIDE{

        public Number apply(Number n1, Number n2) throws CalculatorException{
            return n1.doubleValue() / n2.doubleValue();
        }

    },

    /**
     * Exponenciação.
     */
    POW{

        public Number apply(Number n1, Number n2) throws CalculatorException{

            if(!(n1 instanceof Integer))
                throw new CalculatorException(String.valueOf(n1));

            if(!(n2 instanceof Integer))
                throw new CalculatorException(String.valueOf(n2));

            return Math.pow(n1.doubleValue(),n2.doubleValue());
        }

    },

    /**
     * Radiciação.
     */
    SQUARE{

        public Number apply(Number n1, Number n2) throws CalculatorException{

            if(!(n1 instanceof Integer))
                throw new CalculatorException(String.valueOf(n1));

            if(!(n2 instanceof Integer))
                throw new CalculatorException(String.valueOf(n2));

            return Math.pow(n1.doubleValue(), 1.0 / n2.doubleValue());
        }

    };

    public BigDecimal apply(BigDecimal n1, BigDecimal n2) throws CalculatorException{
        throw new UnsupportedOperationException();
    }

}
