package com.aliengnss.backend.presentacion.dto.res;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.entidades.ProductoSerial;

import lombok.Data;

@Data
public class MovimientoDetalleSerialResponseDto {
	private Long idMovimientoDetalleSerial;
	
	private MovimientoDetalle fkMovimientoDetalle;
	private ProductoSerial fkProductoSerial;
}
