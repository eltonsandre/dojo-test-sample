package com.github.eltonsandre.sample.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author eltonsandre
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Banco {

    @EqualsAndHashCode.Include
    private String nome;
    private List<Conta> listaDeContas;

    public Banco(String nome, List<Conta> listaDeContas) {
        this.nome = nome;
        this.listaDeContas = listaDeContas;
    }

}
