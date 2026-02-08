package com.aliengnss.backend.presentacion.mapeadores;

import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.presentacion.dto.req.VentaRequestDto;
import com.aliengnss.backend.presentacion.dto.res.VentaResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IVentaDTOMapper {
    @Mapping(target = "fkUsuario", ignore = true)
    @Mapping(target = "fechaVenta", ignore = true)
    Venta toDomain(VentaRequestDto dto);

    VentaResponseDto toResponseDto(Venta venta);
}
