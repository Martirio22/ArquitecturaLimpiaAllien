package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.presentacion.dto.res.MovimientoResponseDto;

@Mapper(componentModel = "spring")
public interface IMovimientoDtoMapper {
    
    // ❌ INCORRECTO (lo que tenías)
    // @Mapping(source = "fkUbicacionOrigen.idUbicacion", target = "idUbicacionOrigen")
    
    // ✅ CORRECTO - Pero en realidad NO necesitas este método
    // porque ya manejas la conversión manualmente en el UseCase
    // Movimiento toDomain(MovimientoRequestDto entity);
    
    // ✅ Para el ResponseDTO, mapear desde el objeto Movimiento al DTO
    @Mapping(source = "fkUbicacionOrigen.idUbicacion", target = "idUbicacionOrigen")
    @Mapping(source = "fkUbicacionDestino.idUbicacion", target = "idUbicacionDestino")
    MovimientoResponseDto toResponseDTO(Movimiento movimiento);
}