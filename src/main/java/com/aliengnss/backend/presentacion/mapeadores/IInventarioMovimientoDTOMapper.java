package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;
import com.aliengnss.backend.presentacion.dto.req.InventarioMovimientoRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.InventarioMovimientoResponseDTO;

@Mapper(componentModel = "spring")
public interface IInventarioMovimientoDTOMapper {

	@Mapping(target = "fecha", ignore = true)
	InventarioMovimiento toDomain(InventarioMovimientoRequestDTO dto);
	InventarioMovimientoResponseDTO toResponseDto(InventarioMovimiento inventarioMovimiento);
}
