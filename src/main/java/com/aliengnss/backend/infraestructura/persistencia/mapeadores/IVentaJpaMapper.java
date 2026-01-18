package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IVentaJpaMapper {
    Venta toDomain(VentaJpa entity);
    VentaJpa toEntity(Venta venta);
}
