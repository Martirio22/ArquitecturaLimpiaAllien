package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.VentaDetalleSerial;
import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaDetalleSerialJpa;

@Mapper(componentModel = "spring", uses = Base64Mapper.class)
public interface IVentaDetalleSerialJpaMapper {

    @Mapping(target = "fkDetalleVenta.fkProducto.foto", ignore = true)
    @Mapping(target = "fkProductoSerial.fkProducto.foto", ignore = true)
    VentaDetalleSerial toDomain(VentaDetalleSerialJpa entity);

    @Mapping(target = "fkDetalleVenta.fkProducto.foto", ignore = true)
    @Mapping(target = "fkProductoSerial.fkProducto.foto", ignore = true)
    VentaDetalleSerialJpa toEntity(VentaDetalleSerial ventaDetalleSerial);
}