package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;

@Mapper(componentModel = "spring")
public interface IUsuarioJpaMapper {

	Usuario toDomain(UsuarioJpa entity);
	UsuarioJpa toEntity(Usuario usuario);
}
