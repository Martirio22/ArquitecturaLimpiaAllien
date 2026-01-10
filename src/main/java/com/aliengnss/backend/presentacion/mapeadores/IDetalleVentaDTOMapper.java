package com.aliengnss.backend.presentacion.mapeadores;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.presentacion.dto.req.DetalleVentaRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IDetalleVentaDTOMapper {
    DetalleVenta toDomain(DetalleVentaRequestDto entity);
    DetalleVentaRequestDto toResponseDto(DetalleVenta detalleVenta);
}
