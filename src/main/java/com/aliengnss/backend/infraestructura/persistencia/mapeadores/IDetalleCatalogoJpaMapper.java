package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.DetalleCatalogo;
import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleCatalogoJpa;

@Mapper(componentModel = "spring")
public interface IDetalleCatalogoJpaMapper {
	@Mapping(source = "catalogo.idCatalogo", target = "idCatalogo")
    DetalleCatalogo toDomain(DetalleCatalogoJpa entity);

    @Mapping(source = "idCatalogo", target = "catalogo.idCatalogo")
    DetalleCatalogoJpa toEntity(DetalleCatalogo detalleCatalogo);
}
