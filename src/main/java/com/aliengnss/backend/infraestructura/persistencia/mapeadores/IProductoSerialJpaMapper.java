package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import com.aliengnss.backend.dominio.entidades.ProductoSerial;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoSerialJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface IProductoSerialJpaMapper {
	ProductoSerial toDomain(ProductoSerialJpa entity);
	ProductoSerialJpa toEntity(ProductoSerial productoSerial);
}
