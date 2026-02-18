package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;

@Mapper(componentModel = "spring")
public interface ICompraProductoDetalleJpaMapper {

	CompraProductoDetalle toDomain(CompraProductoDetalleJpa entity);
	CompraProductoDetalleJpa toEntity(CompraProductoDetalle compraproductodetalle);
}
