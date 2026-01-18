package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.presentacion.dto.req.ProductoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.ProductoResponseDto;

@Mapper(componentModel = "spring")
public interface IProductoDTOMapper {
	Producto toDomain(ProductoRequestDto entity);
	ProductoResponseDto toResponseDto(Producto producto);
}
