package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoResponseDto;

@Mapper(componentModel = "spring")
public interface IMovimientoDtoMapper {


    Movimiento toDomain(MovimientoRequestDto dto);


    MovimientoResponseDto toResponseDto(Movimiento movimiento);
}
