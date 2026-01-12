package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.ProductoSerial;
import com.aliengnss.backend.presentacion.dto.req.ProductoSerialRequestDto;
import com.aliengnss.backend.presentacion.dto.res.ProductoSerialResponseDto;

@Mapper(componentModel = "spring")

public interface IProductoSerialDTOMapper {
	ProductoSerial toDomain(ProductoSerialRequestDto entity);
	ProductoSerialResponseDto toResponseDto(ProductoSerial productoSerial);
}
