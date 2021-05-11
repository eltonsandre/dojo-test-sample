package com.github.eltonsandre.sample.stubs.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.eltonsandre.sample.cucumber.ContaClient;
import com.github.eltonsandre.sample.domain.model.Conta;
import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

@Component
@RequiredArgsConstructor
public class ContaClientStub {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void buscarConta(final Conta conta) {
        WireMock.stubFor(get(ContaClient.URI_BUSCAR_CONTA)
                .willReturn(aResponse().withBody(this.objectMapper.writeValueAsString(conta))));

    }

}
