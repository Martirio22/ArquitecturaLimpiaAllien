package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.presentacion.dto.request.MovimientoRequestDto;
import com.aliengnss.backend.presentacion.dto.response.MovimientoResponseDto;

@Mapper(componentModel = "spring")
public interface IMovimientoDtoMapper {
	Movimiento toDomain(MovimientoRequestDto dto);

	MovimientoResponseDto toResponseDTO(Movimiento movimiento);
}
