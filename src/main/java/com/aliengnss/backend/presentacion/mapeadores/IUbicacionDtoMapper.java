package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.presentacion.dto.req.UbicacionRequestDto;
import com.aliengnss.backend.presentacion.dto.res.UbicacionResponseDto;



@Mapper(componentModel = "spring")
public interface IUbicacionDtoMapper {
	Ubicacion toDomain(UbicacionRequestDto dto);

	UbicacionResponseDto toResponseDTO(Ubicacion ubicacion);
}
