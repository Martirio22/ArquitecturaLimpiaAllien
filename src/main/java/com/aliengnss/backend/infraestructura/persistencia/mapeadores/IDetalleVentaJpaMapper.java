package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleVentaJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = Base64Mapper.class)
public interface IDetalleVentaJpaMapper {

    @Mapping(target = "fkProducto.foto", ignore = true)
    DetalleVenta toDomain(DetalleVentaJpa entity);

    @Mapping(target = "fkProducto.foto", ignore = true)
    DetalleVentaJpa toEntity(DetalleVenta detalleVenta);
}