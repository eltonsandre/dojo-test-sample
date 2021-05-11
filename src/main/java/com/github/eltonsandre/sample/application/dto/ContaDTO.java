package com.github.eltonsandre.sample.application.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.eltonsandre.sample.application.validation.ContaGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContaDTO {

    private String dono;

    @NotBlank
    private String banco;

    @NotBlank
    private String agencia;

    @NotBlank
    private String numero;

    @JsonView({ContaGroup.Deposito.class, ContaGroup.Saque.class})
    private BigDecimal saldo;

    @JsonView({ContaGroup.Deposito.class, ContaGroup.Saque.class})
    private BigDecimal limite;

    @NotBlank(groups = ContaGroup.Deposito.class)
    private BigDecimal deposito;

    @NotBlank(groups = ContaGroup.Saque.class)
    private BigDecimal saque;

}
