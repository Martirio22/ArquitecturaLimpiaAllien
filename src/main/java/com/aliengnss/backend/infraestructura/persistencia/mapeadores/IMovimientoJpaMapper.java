package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;


@Mapper(componentModel = "spring")
public interface IMovimientoJpaMapper {
	Movimiento toDomain(MovimientoJpa entity);

	MovimientoJpa toEntity(Movimiento movimiento);
}

