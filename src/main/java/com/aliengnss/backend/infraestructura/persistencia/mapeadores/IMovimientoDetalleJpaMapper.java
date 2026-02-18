package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;

@Mapper(componentModel = "spring")
public interface IMovimientoDetalleJpaMapper {
	MovimientoDetalle toDomain(MovimientoDetalleJpa entity);

	MovimientoDetalleJpa toEntity(MovimientoDetalle movimientoDetalle);
}
