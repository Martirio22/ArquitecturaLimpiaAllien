package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.MovimientoSeries;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoSeriesJpa;

@Mapper(componentModel = "spring")

public interface IMovimientoSeriesJpaMapper {
	MovimientoSeries toDomain(MovimientoSeriesJpa entity);
	MovimientoSeriesJpa toEntity(MovimientoSeries movimientoSeries);
}
