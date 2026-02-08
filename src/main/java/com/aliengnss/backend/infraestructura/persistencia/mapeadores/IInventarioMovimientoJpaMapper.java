package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;
import com.aliengnss.backend.infraestructura.persistencia.jpa.InventarioMovimientoJpa;

@Mapper(componentModel = "spring", uses = Base64Mapper.class)
public interface IInventarioMovimientoJpaMapper {

    // Ignorar foto si viene por fkProducto
    @Mapping(target = "fkProducto.foto", ignore = true)
    // Ignorar foto si viene por fkProductoSerial -> fkProducto
    @Mapping(target = "fkProductoSerial.fkProducto.foto", ignore = true)
    InventarioMovimiento toDomain(InventarioMovimientoJpa entity);

    @Mapping(target = "fkProducto.foto", ignore = true)
    @Mapping(target = "fkProductoSerial.fkProducto.foto", ignore = true)
    InventarioMovimientoJpa toEntity(InventarioMovimiento inventarioMovimiento);
}