package com.github.eltonsandre.sample.domain.mapper;

import com.github.eltonsandre.sample.application.dto.ContaDTO;
import com.github.eltonsandre.sample.domain.model.Conta;
import org.mapstruct.Mapper;

@Mapper
public interface ContaMapper {

    Conta toModel(ContaDTO contaDTO);

    //    @Mapping(target = "saque", source = "")
//    @Mapping(target = "deposito", source = "")
    ContaDTO toDto(Conta conta);

}
