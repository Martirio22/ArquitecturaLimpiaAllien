package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;
import com.aliengnss.backend.presentacion.dto.req.ProductoPrecioVentaRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.ProductoPrecioVentaResponseDTO;

@Mapper(componentModel = "spring")
public interface IProductoPrecioVentaDtoMapper {
	ProductoPrecioVenta toDomain(ProductoPrecioVentaRequestDTO entity);
	ProductoPrecioVentaResponseDTO toResponseDto(ProductoPrecioVenta productoPrecioVenta);
}
