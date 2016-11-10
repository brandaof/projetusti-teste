package br.com.projetusti.teste.remote {

import mx.rpc.AbstractOperation;

import mx.rpc.AsyncToken;

import mx.rpc.remoting.mxml.RemoteObject;

/**
 * Base para qualquer objeto remoto.
 * @author Brandao
 * @since 11/10/2015
 * @version 1.0.0
 */

public class GenericRemoteObject extends RemoteObject {

    public function GenericRemoteObject() {
    }

    [Init]
    public function init():void {
        super.channelSet = EndpointManager.CHANNEL_SET;
    }

    public function invoke(method:String, args:Array):AsyncToken {
        var operation:AbstractOperation = getOperation(method);
        operation.arguments = args;
        return operation.send();
    }

}
}
