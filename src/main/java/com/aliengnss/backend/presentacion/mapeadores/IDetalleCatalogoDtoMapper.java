package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.DetalleCatalogo;
import com.aliengnss.backend.presentacion.dto.req.DetalleCatalogoRequestDto;
import com.aliengnss.backend.presentacion.dto.res.DetalleCatalogoResponseDto;

@Mapper(componentModel = "spring")
public interface IDetalleCatalogoDtoMapper {
	DetalleCatalogo toDomain(DetalleCatalogoRequestDto entity);
	DetalleCatalogoResponseDto toResponseDto(DetalleCatalogo detalleCatalogo);
}
