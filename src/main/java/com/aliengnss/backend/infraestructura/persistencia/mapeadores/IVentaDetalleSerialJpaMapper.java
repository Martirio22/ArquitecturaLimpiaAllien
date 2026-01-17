package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.VentaDetalleSerial;
import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaDetalleSerialJpa;

@Mapper(componentModel = "spring")
public interface IVentaDetalleSerialJpaMapper {

	VentaDetalleSerial toDomain(VentaDetalleSerialJpa entity);
	VentaDetalleSerialJpa toEntity(VentaDetalleSerial ventaDetalleSerial);
}
