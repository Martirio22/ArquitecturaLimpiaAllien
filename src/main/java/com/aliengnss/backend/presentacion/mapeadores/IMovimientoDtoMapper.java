package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.presentacion.dto.res.MovimientoDetalleResponseDto;
import com.aliengnss.backend.presentacion.dto.res.MovimientoResponseDto;

@Mapper(componentModel = "spring")
public interface IMovimientoDtoMapper {
    
    @Mapping(source = "fkUbicacionOrigen.idUbicacion", target = "idUbicacionOrigen")
    @Mapping(source = "fkUbicacionDestino.idUbicacion", target = "idUbicacionDestino")
    @Mapping(source = "detalles", target = "detalles") // ✅ Mapear detalles
    MovimientoResponseDto toResponseDTO(Movimiento movimiento);
    
    // ✅ Mapear detalle individual
    @Mapping(source = "fkProducto", target = "fkProducto")
    MovimientoDetalleResponseDto toDetalleResponseDTO(MovimientoDetalle detalle);
}