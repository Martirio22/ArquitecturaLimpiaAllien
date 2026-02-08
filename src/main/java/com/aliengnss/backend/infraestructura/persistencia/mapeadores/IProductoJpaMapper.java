package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import java.util.Base64;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;

@Mapper(componentModel = "spring", uses = Base64Mapper.class)
public interface IProductoJpaMapper {

    @Mapping(target = "foto", source = "foto", qualifiedByName = "bytesToBase64")
    Producto toDomain(ProductoJpa entity);

    @Mapping(target = "foto", source = "foto", qualifiedByName = "base64ToBytes")
    ProductoJpa toEntity(Producto producto);
}