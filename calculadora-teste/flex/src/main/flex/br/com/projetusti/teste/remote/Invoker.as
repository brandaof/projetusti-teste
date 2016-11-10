package br.com.projetusti.teste.remote {

import mx.rpc.Responder;

/**
 * Prepara a invocação de um método remoto.
 * @author Brandao
 * @since 11/10/2015
 * @version 1.0.0
 */

public class Invoker {

    private var method:String;

    private var args:Array;

    private var object:GenericRemoteObject;

    /**
     * Cria uma nova instância.
     * @param method Nome do método que será invocado.
     * @param args Parâmetros do método.
     * @param object Auxilia a invocação dos métodos.
     */
    public function Invoker(method:String, args:Array, object:GenericRemoteObject) {
        this.method = method;
        this.args   = args;
        this.object = object;
    }

    /**
     * Invoca o método.
     * @param success Executa caso a invocação retorne um resultado esperado.
     * @param fault Executa caso a invocação resulte em uma exceção.
     */
    public function invoke(success:Function, fault:Function):void{
        this.object.invoke(this.method,this.args)
                .addResponder(
                    new Responder(
                            success,
                            fault));
    }

}
}
