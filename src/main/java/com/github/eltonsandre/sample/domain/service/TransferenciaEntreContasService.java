package com.github.eltonsandre.sample.domain.service;

import com.github.eltonsandre.sample.domain.exception.SaldoInsuficienteException;
import com.github.eltonsandre.sample.domain.exception.TranferenciaNaoRealizadaException;
import com.github.eltonsandre.sample.domain.model.Conta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferenciaEntreContasService {


    public boolean transferir(final Conta contaOrigem, final Conta contaDestino, final BigDecimal valor) {
        if (contaOrigem.naoTemSaldoSuficiente(valor)) {
            throw new SaldoInsuficienteException();
        }

        var saqueRealizado = contaDestino.sacar(valor);

        if (saqueRealizado) {
            try {
                this.transferirParaContaDestino(contaDestino, valor);
            } catch (Exception e) {
                contaOrigem.estornar(valor);
                throw new TranferenciaNaoRealizadaException();
            }
        } else {
            throw new TranferenciaNaoRealizadaException();
        }
        return true;
    }


    private void transferirParaContaDestino(final Conta contaDestino, final BigDecimal valor) {
        if (!contaDestino.depositar(valor)) {
            throw new TranferenciaNaoRealizadaException();
        }
    }


}
