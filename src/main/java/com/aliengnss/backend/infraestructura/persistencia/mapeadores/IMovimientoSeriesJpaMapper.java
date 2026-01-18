package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleSerialJpa;

@Mapper(componentModel = "spring")

public interface IMovimientoSeriesJpaMapper {
	MovimientoDetalleSerial toDomain(MovimientoDetalleSerialJpa entity);
	MovimientoDetalleSerialJpa toEntity(MovimientoDetalleSerial movimientoSeries);
}
