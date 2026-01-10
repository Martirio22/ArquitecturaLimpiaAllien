package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleVentaJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IDetalleVenta {
    DetalleVenta toDomain(DetalleVentaJpa entity);
    DetalleVentaJpa toEntity(DetalleVenta detalleVenta);
}
