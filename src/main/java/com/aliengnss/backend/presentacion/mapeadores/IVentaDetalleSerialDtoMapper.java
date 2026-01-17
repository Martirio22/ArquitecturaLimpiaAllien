package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.VentaDetalleSerial;
import com.aliengnss.backend.presentacion.dto.req.VentaDetalleSerialRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.VentaDetalleSerialResponseDTO;

@Mapper(componentModel = "spring")
public interface IVentaDetalleSerialDtoMapper {

	VentaDetalleSerial toDomain(VentaDetalleSerialRequestDTO dto);
	VentaDetalleSerialResponseDTO toResponseDto(VentaDetalleSerial ventaDetalleSerial);
}
