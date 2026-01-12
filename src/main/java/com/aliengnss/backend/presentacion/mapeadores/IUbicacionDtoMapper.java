package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.presentacion.dto.request.UbicacionRequestDto;
import com.aliengnss.backend.presentacion.dto.response.UbicacionResponseDto;



@Mapper(componentModel = "spring")
public interface IUbicacionDtoMapper {
	Ubicacion toDomain(UbicacionRequestDto dto);

	UbicacionResponseDto toResponseDTO(Ubicacion ubicacion);
}
