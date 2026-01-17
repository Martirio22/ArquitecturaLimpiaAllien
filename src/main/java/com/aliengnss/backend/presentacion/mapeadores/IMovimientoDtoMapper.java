package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.presentacion.dto.res.MovimientoResponseDto;

@Mapper(componentModel = "spring")
public interface IMovimientoDtoMapper {
	@Mapping(
	        source = "fkUbicacionOrigen.idUbicacion",
	        target = "idUbicacionOrigen"
	    )
	    @Mapping(
	        source = "fkUbicacionDestino.idUbicacion",
	        target = "idUbicacionDestino"
	    )
	    MovimientoResponseDto toResponseDTO(Movimiento movimiento);
}
