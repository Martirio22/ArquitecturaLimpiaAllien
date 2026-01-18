package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoJpa;

@Mapper(componentModel = "spring")
public interface ICompraProductoJpaMapper {
	CompraProducto toDomain(CompraProductoJpa entity);
	CompraProductoJpa toEntity(CompraProducto compraproducto);
}
