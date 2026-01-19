package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoResponseDto;

@Mapper(componentModel = "spring")
public interface IMovimientoDtoMapper {

    // Request -> Dominio (para POST)
    @Mapping(target = "idMovimiento", ignore = true) // normalmente lo genera BD
    @Mapping(target = "fkUsuario", ignore = true)    // lo seteas en usecase/servicio por id
    @Mapping(target = "fkUbicacionOrigen", ignore = true)
    @Mapping(target = "fkUbicacionDestino", ignore = true)
    Movimiento toDomain(MovimientoRequestDto dto);

    // Dominio -> Response
    @Mapping(source = "fkUbicacionOrigen.idUbicacion", target = "idUbicacionOrigen")
    @Mapping(source = "fkUbicacionDestino.idUbicacion", target = "idUbicacionDestino")
    @Mapping(source = "fkUsuario.idUsuario", target = "idUsuario") // si existe en tu response
    MovimientoResponseDto toResponseDto(Movimiento movimiento);
}
