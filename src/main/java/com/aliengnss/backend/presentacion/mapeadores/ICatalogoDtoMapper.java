package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.Catalogo;
import com.aliengnss.backend.presentacion.dto.req.CatalogoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.CatalogoResponseDto;

@Mapper(componentModel = "spring")
public interface ICatalogoDtoMapper {
	Catalogo toDomain(CatalogoRequestDto entity);
	CatalogoResponseDto toResponseDto(Catalogo catalogo);
}
