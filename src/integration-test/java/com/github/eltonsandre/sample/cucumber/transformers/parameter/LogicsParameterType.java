package com.github.eltonsandre.sample.cucumber.transformers.parameter;

import io.cucumber.java.ParameterType;

public class LogicsParameterType {

    @ParameterType("(verdadeiro|falso)")
    public boolean logico(final String type) {
        return "verdadeiro".equals(type);
    }

    @ParameterType("(fechado|desmascarado|aberto)")
    public boolean fechado(final String type) {
        return "mascarado".equals(type);
    }

    @ParameterType("(aceito|aceitou|sem aceite|não aceito|não aceitou)")
    public boolean aceite(final String type) {
        return "aceito".equals(type) || "aceitou".equals(type);
    }

    @ParameterType("(válido|inválido)")
    public boolean valido(final String valido) {
        return "válido".equals(valido);
    }

    @ParameterType("(confirmado|não confirmado|sem confirmação)")
    public boolean confirmado(final String confirmado) {
        return "confirmado".equals(confirmado);
    }

    @ParameterType("(completo|incompleto|não completo)")
    public boolean completo(final String completo) {
        return "completo".equals(completo);
    }

    @ParameterType("(cadastrado|não cadastrado|sem cadastro)")
    public boolean cadastrado(final String cadastrado) {
        return "cadastrado".equals(cadastrado);
    }

}
