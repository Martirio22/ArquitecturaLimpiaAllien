package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;



@Mapper(componentModel = "spring")
public interface IUbicacionJpaMapper {
	Ubicacion toDomain(UbicacionJpa entity);

	UbicacionJpa toEntity(Ubicacion ubicacion);
}
