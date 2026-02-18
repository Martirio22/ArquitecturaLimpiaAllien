package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;
import com.aliengnss.backend.presentacion.dto.req.MovimientoDetalleSerialRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoDetalleSerialResponseDto;

@Mapper(componentModel = "spring")

public interface IMovimientoSeriesDTOMapper {
	MovimientoDetalleSerial toDomain(MovimientoDetalleSerialRequestDto entity);
	MovimientoDetalleSerialResponseDto toResponseDto(MovimientoDetalleSerial movimientoSeries);
}
