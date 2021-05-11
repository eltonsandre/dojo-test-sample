package com.github.eltonsandre.sample.application.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.eltonsandre.sample.application.validation.ContaGroup;
import com.github.eltonsandre.sample.domain.ContaClient;
import com.github.eltonsandre.sample.domain.application.dto.ContaDTO;
import com.github.eltonsandre.sample.domain.application.mapper.ContaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("conta")
@RequiredArgsConstructor
public class ContaResource {

    private final ContaClient contaClient;
    private final ContaMapper contaMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Mono<ContaDTO> buscarConta(@RequestParam ContaDTO contaDTO) {
        final var conta = this.contaMapper.toModel(contaDTO);

        return this.contaClient.buscarConta(conta)
                .map(this.contaMapper::toDto);
    }

    @PostMapping("deposito")
    @JsonView(ContaGroup.Deposito.class)
    public Mono<ContaDTO> depositar(@RequestParam ContaDTO contaDTO) {
        final var conta = this.contaMapper.toModel(contaDTO);

        return this.contaClient.depositar(conta)
                .map(this.contaMapper::toDto);
    }

    @PostMapping("saque")
    @JsonView(ContaGroup.Saque.class)
    public Mono<ContaDTO> sacar(@RequestParam ContaDTO contaDTO) {
        final var conta = this.contaMapper.toModel(contaDTO);

        return this.contaClient.sacar(conta)
                .map(this.contaMapper::toDto);
    }

}
