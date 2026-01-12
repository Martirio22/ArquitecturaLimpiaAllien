package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;

@Mapper(componentModel = "spring")

public interface IProductoJpaMapper {
	Producto toDomain(ProductoJpa entity);
	ProductoJpa toEntity(Producto producto);
}
