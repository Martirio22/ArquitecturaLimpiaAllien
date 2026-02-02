package com.aliengnss.backend.presentacion.dto.req;

import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.entidades.ProductoSerial;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class MovimientoDetalleSerialRequestDto {
	@Null
	private Long idMovimientoDetalleSerial;
	@NotNull
	private Long idMovimientoDetalle;
	@NotNull
	private ProductoSerial fkProductoSerial;
}
