package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.presentacion.dto.req.CompraProductoDetalleRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.CompraProductoDetalleResponseDTO;

@Mapper(componentModel = "spring")
public interface ICompraProductoDetalleDtoMapper {

	CompraProductoDetalle toDomain(CompraProductoDetalleRequestDTO dto);
	CompraProductoDetalleResponseDTO toResponseDto(CompraProductoDetalle compraproductodetalle);
}
