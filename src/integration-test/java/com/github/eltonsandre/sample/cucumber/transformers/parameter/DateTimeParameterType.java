package com.github.eltonsandre.sample.cucumber.transformers.parameter;

import io.cucumber.java.ParameterType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeParameterType {

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDate data(final String dia, final String mes, final String ano) {
        return LocalDate.of(Integer.parseInt(ano), Integer.parseInt(mes), Integer.parseInt(dia));
    }

    @ParameterType("([0-1]{1}[0-9]{1}|[1-2]{1}[0-3]{1})[:|h]([0-5]{1}[0-9]{1})")
    public LocalTime hora(final String hora, final String minutos, final String segundo) {
        return LocalTime.of(Integer.parseInt(hora), Integer.parseInt(minutos), Integer.parseInt(segundo));
    }

    @ParameterType("(\\d{1,2})\\/(\\d{1,2})\\/(\\d{2,4})|([0-1]{1}\\d{1}|[1-2]{1}[0-3]{1})[:|h]([0-5]{1}\\d{1})")
    public LocalDateTime dataHora(final String dia, final String mes, final String ano,
                                  final String hora, final String minutos, final String segundo) {
        return LocalDateTime.of(this.data(dia, mes, ano), this.hora(hora, minutos, segundo));
    }

}
