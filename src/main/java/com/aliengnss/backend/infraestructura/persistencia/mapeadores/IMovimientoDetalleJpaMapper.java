package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;

@Mapper(componentModel = "spring", uses = Base64Mapper.class)
public interface IMovimientoDetalleJpaMapper {

    @Mapping(target = "fkProducto.foto", ignore = true)
    MovimientoDetalle toDomain(MovimientoDetalleJpa entity);

    @Mapping(target = "fkProducto.foto", ignore = true)
    MovimientoDetalleJpa toEntity(MovimientoDetalle movimientoDetalle);
}