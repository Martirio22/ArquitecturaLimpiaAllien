package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.MovimientoSeries;
import com.aliengnss.backend.presentacion.dto.req.MovimientoSeriesRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoSeriesResponseDto;

@Mapper(componentModel = "spring")

public interface IMovimientoSeriesDTOMapper {
	MovimientoSeries toDomain(MovimientoSeriesRequestDto entity);
	MovimientoSeriesResponseDto toResponseDto(MovimientoSeries movimientoSeries);
}
