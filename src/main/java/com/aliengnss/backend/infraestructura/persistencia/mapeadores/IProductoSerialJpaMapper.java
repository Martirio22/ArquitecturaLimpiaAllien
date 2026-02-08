package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import com.aliengnss.backend.dominio.entidades.ProductoSerial;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoSerialJpa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = Base64Mapper.class)
public interface IProductoSerialJpaMapper {

    @Mapping(target = "fkProducto.foto", ignore = true)
    ProductoSerial toDomain(ProductoSerialJpa entity);

    @Mapping(target = "fkProducto.foto", ignore = true)
    ProductoSerialJpa toEntity(ProductoSerial productoSerial);
}