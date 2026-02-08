package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalleSerial;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleSerialJpa;


@Mapper(componentModel = "spring", uses = Base64Mapper.class)
public interface IMovimientoSeriesJpaMapper {

    @Mapping(target = "fkMovimientoDetalle.fkProducto.foto", ignore = true)
    @Mapping(target = "fkProductoSerial.fkProducto.foto", ignore = true)
    MovimientoDetalleSerial toDomain(MovimientoDetalleSerialJpa entity);

    @Mapping(target = "fkMovimientoDetalle.fkProducto.foto", ignore = true)
    @Mapping(target = "fkProductoSerial.fkProducto.foto", ignore = true)
    MovimientoDetalleSerialJpa toEntity(MovimientoDetalleSerial movimientoSeries);
}