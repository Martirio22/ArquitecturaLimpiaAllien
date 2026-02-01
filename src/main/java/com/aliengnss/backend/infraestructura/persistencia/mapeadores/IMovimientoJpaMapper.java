package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;

@Mapper(componentModel = "spring")
public interface IMovimientoJpaMapper {
    
    // Mapeo principal de Movimiento
    @Mapping(source = "detalles", target = "detalles")
    Movimiento toDomain(MovimientoJpa entity);

    @Mapping(source = "detalles", target = "detalles")
    MovimientoJpa toEntity(Movimiento movimiento);
    
    // ✅ Mapeo explícito de MovimientoDetalle (rompe referencia circular)
    @Mapping(source = "fkProducto", target = "fkProducto")
    @Mapping(target = "fkMovimiento", ignore = true) // 🔥 CLAVE: ignora la referencia de vuelta
    MovimientoDetalle toDomain(MovimientoDetalleJpa detalleJpa);
    
    @Mapping(source = "fkProducto", target = "fkProducto")
    @Mapping(target = "fkMovimiento", ignore = true) // 🔥 CLAVE: ignora la referencia de vuelta
    MovimientoDetalleJpa toEntity(MovimientoDetalle detalle);
}