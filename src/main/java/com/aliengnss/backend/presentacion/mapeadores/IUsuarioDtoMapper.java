package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.presentacion.dto.req.UsuarioRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.UsuarioResponseDTO;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {

	Usuario toDomain(UsuarioRequestDTO dto);
	UsuarioResponseDTO toResponseDto(Usuario usuario);
}
