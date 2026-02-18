package com.aliengnss.backend.presentacion.mapeadores;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.presentacion.dto.req.DetalleVentaRequestDto;
import com.aliengnss.backend.presentacion.dto.res.DetalleVentaResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IDetalleVentaDTOMapper {
    DetalleVenta toDomain(DetalleVentaRequestDto entity);
    DetalleVentaResponseDto toResponseDto(DetalleVenta detalleVenta);
}
