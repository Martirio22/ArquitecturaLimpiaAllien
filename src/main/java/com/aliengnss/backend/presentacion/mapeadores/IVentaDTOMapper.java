package com.aliengnss.backend.presentacion.mapeadores;

import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.presentacion.dto.req.VentaRequestDto;
import com.aliengnss.backend.presentacion.dto.res.VentaResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IVentaDTOMapper {
    Venta toDomain(VentaRequestDto entity);
    VentaResponseDto toResponseDto(Venta venta);
}
