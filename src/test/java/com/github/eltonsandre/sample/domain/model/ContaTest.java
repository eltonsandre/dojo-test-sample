package com.github.eltonsandre.sample.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContaTest {

    private Conta conta;

    private Transferencia

    @BeforeEach

    void inicializar() {
        this.conta = new Conta();
    }

    @Test
    void transferirValorDeContaOrigemParaContaDestino() {

        Conta contaDestino = new Conta();
        contaDestino.depositar(new BigDecimal(20));

        this.conta.transferir(50, contaDestino);


    }

}