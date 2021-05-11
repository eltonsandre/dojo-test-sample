package com.github.eltonsandre.sample.cucumber.definitions;

import com.github.eltonsandre.sample.cucumber.SpringContextCucumber;
import com.github.eltonsandre.sample.domain.model.Banco;
import com.github.eltonsandre.sample.domain.model.Conta;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author eltonsandre
 */
public class BancoTestePassos extends SpringContextCucumber {

    private Banco banco;
    private int totalContas;
    private BigDecimal totalDinheiro;

    @Dado("que as contas são do {}")
    public void queAsContasSaoDo(final String nome, final List<Conta> contas) {
        // Definição do banco e associando as contas
        this.banco = new Banco(nome, contas);
    }

    @Dado("o calculo do total de contas criadas")
    public void oCalculoDoTotalDeContasCriadas() {
        this.totalContas = this.banco.getListaDeContas().size();
    }

    @Entao("o total de contas e {int}")
    public void oTotalDeContasE(final int totalContasEsperado) {
        assertEquals("O cálculo do total de contas está incorreto", totalContasEsperado, this.totalContas);
    }

    @Dado("o calculo do total de dinheiro")
    public void oCalculoDoTotalDeDinheiro() {
        this.totalDinheiro = this.banco.getListaDeContas().stream()
                .map(Conta::getSaldo)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    @Entao("o total de dinheiro no banco e {bigdecimal}")
    public void oTotalDeDinheiroNoBancoE(final BigDecimal totalDinheiroEsperado) {
        assertEquals("O cálculo do total de dinheiro no banco " + this.banco.getNome() + " está incorreto",
                totalDinheiroEsperado.setScale(2, RoundingMode.HALF_EVEN),
                this.totalDinheiro.setScale(2, RoundingMode.HALF_EVEN));
    }


}