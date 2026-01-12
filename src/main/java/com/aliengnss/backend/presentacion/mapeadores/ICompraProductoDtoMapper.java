package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.presentacion.dto.req.CompraProductoRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.CompraProductoResponseDTO;

@Mapper(componentModel = "spring")
public interface ICompraProductoDtoMapper {

	CompraProducto toDomain(CompraProductoRequestDTO dto);
	CompraProductoResponseDTO toResponseDto(CompraProducto compraproducto);
}
