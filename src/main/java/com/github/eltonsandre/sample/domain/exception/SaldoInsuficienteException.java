package com.github.eltonsandre.sample.domain.exception;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException() {
        super("Saldo insulficiente");
    }
    
    public SaldoInsuficienteException(final String message) {
        super(message);
    }

}
