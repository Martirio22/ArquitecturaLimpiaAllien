package com.aliengnss.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;
import com.aliengnss.backend.presentacion.dto.req.InventarioMovimientoRequestDTO;
import com.aliengnss.backend.presentacion.dto.res.InventarioMovimientoResponseDTO;

@Mapper(componentModel = "spring")
public interface IInventarioMovimientoDTOMapper {

	InventarioMovimiento toDomain(InventarioMovimientoRequestDTO dto);
	InventarioMovimientoResponseDTO toResponseDto(InventarioMovimiento inventarioMovimiento);
}
