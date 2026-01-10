package com.aliengnss.backend.presentacion.mapeadores;

import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.presentacion.dto.req.ClienteRequestDto;
import com.aliengnss.backend.presentacion.dto.res.ClienteResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClienteDTOMapper {
    Cliente toDomain(ClienteRequestDto entity);
    ClienteResponseDto toResponseDto(Cliente cliente);
}
