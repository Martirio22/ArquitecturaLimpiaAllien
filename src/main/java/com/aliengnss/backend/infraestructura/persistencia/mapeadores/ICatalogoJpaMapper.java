package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Catalogo;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CatalogoJpa;

@Mapper(componentModel = "spring")
public interface ICatalogoJpaMapper {
	Catalogo toDomain(CatalogoJpa entity);
	CatalogoJpa toEntity(Catalogo catalogo);
}
