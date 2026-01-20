package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.presentacion.dto.req.MovimientoDetalleRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoDetalleResponseDto;

@Mapper(componentModel = "spring")
public interface IMovimientoDetalleDtoMapper {
	MovimientoDetalle toDomain(MovimientoDetalleRequestDto dto);

	MovimientoDetalleResponseDto toResponseDto(MovimientoDetalle movimientoDetalle);
}
