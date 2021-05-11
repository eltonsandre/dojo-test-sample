package com.github.eltonsandre.sample.cucumber.definitions;

import com.github.eltonsandre.sample.cucumber.ContaClient;
import com.github.eltonsandre.sample.cucumber.SpringContextCucumber;
import com.github.eltonsandre.sample.domain.model.Conta;
import com.github.eltonsandre.sample.stubs.clients.ContaClientStub;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import lombok.RequiredArgsConstructor;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RequiredArgsConstructor//(onConstructor_ = @Autowired)
public class ContaTestePassos extends SpringContextCucumber {

    private final ContaClientStub contaClientStub;
    private Conta conta;

    @Dado("que a conta criada com os seguintes dados")
    public void criaContaComLimiteESaldo(final Conta conta) {
        this.contaClientStub.buscarConta(conta);
        final WebTestClient.ResponseSpec exchange = this.webTestClient.get()
                .uri(ContaClient.URI_BUSCAR_CONTA, conta.getBanco(), conta.getAgencia(), conta.getNumero()).exchange();
        this.conta = conta;
    }

    @Quando("o dono realiza o deposito no valor de R${bigdecimal} em conta")
    public void oDonoRealizaODepositoNoValorDeDepositoNaConta(final BigDecimal valorDeposito) {
        assertTrue(this.conta.getDono() + " não tem limite disponível para este deposito",
                this.conta.depositar(valorDeposito));
    }

    @E("sacar o valor de R${bigdecimal}")
    public void sacarOValorDeR$PrimeiroSaque(final BigDecimal valorSaque) {
        assertTrue(this.conta.getDono() + " não tem saldo disponível para este saque",
                this.conta.sacar(valorSaque));
    }

    @Entao("deverá ter em conta o saldo de R${bigdecimal}")
    public void oDonoDeveraTerSaldoDeSaldoEsperadoEmConta(final BigDecimal saldoEsperado) {
        assertEquals(this.conta.getDono() + " está com o saldo incorreto em conta",
                saldoEsperado, this.conta.getSaldo());
    }

}