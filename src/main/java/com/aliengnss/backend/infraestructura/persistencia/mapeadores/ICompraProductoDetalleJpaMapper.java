package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;

@Mapper(componentModel = "spring", uses = Base64Mapper.class)
public interface ICompraProductoDetalleJpaMapper {

    @Mapping(target = "fkProducto.foto", ignore = true)
    CompraProductoDetalle toDomain(CompraProductoDetalleJpa entity);

    @Mapping(target = "fkProducto.foto", ignore = true)
    CompraProductoDetalleJpa toEntity(CompraProductoDetalle compraproductodetalle);
}