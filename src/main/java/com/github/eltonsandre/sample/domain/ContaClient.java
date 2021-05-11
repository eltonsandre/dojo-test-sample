package com.github.eltonsandre.sample.domain;


import com.github.eltonsandre.sample.domain.model.Conta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ContaClient {

    public static final String URI_BUSCAR_CONTA = "conta/{banco}/{agencia}/{numero}";

    private final WebClient webClient;

    public Mono<Conta> buscarConta(final Conta conta) {
        return this.webClient.get()
                .uri(URI_BUSCAR_CONTA, conta.getBanco(), conta.getAgencia(), conta.getNumero())
                .retrieve()
                .bodyToMono(Conta.class);
    }


    public Mono<Conta> depositar(final Conta conta) {
        return this.webClient.post()
                .uri("conta/deposito")
                .bodyValue(conta)
                .retrieve()
                .bodyToMono(Conta.class);
    }

    public Mono<Conta> sacar(final Conta conta) {
        return this.webClient.post()
                .uri("conta/saque")
                .bodyValue(conta)
                .retrieve()
                .bodyToMono(Conta.class);
    }

}
