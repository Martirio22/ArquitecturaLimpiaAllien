package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.presentacion.dto.request.MovimientoDetalleRequestDto;
import com.aliengnss.backend.presentacion.dto.response.MovimientoDetalleResponseDto;

@Mapper(componentModel = "spring")
public interface IMovimientoDetalleDtoMapper {
	MovimientoDetalle toDomain(MovimientoDetalleRequestDto dto);

	MovimientoDetalleResponseDto toResponseDTO(MovimientoDetalle movimientoDetalle);
}
