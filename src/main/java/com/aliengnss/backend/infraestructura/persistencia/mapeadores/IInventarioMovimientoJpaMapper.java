package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;
import com.aliengnss.backend.infraestructura.persistencia.jpa.InventarioMovimientoJpa;

@Mapper(componentModel = "spring")
public interface IInventarioMovimientoJpaMapper {
	InventarioMovimiento toDomain(InventarioMovimientoJpa entity);
	InventarioMovimientoJpa toEntity(InventarioMovimiento inventarioMovimiento);

}
