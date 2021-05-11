package com.github.eltonsandre.sample.domain.exception;

public class TranferenciaNaoRealizadaException extends RuntimeException {

    public TranferenciaNaoRealizadaException(final String mensagem) {
        super(mensagem);
    }

    public TranferenciaNaoRealizadaException() {
        super("Transferência não realizada!");
    }

}
