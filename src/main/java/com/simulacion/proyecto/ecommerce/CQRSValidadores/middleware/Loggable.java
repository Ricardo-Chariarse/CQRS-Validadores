package com.simulacion.proyecto.ecommerce.CQRSValidadores.middleware;

import an.awesome.pipelinr.Command;

public class Loggable implements Command.Middleware {

    @Override
    public <R, C extends Command<R>> R invoke(C command, Next<R> next) {
        // log command
        R response = next.invoke();
        // log response
        return response;
    }
}
