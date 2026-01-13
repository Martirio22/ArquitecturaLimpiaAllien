package com.aliengnss.backend.presentacion.dto.req;

import lombok.Data;

@Data
public class MovimientoSeriesRequestDto {
	private Long idMovimientoSeries;
	private Long idMovimientoDetalle;
	private Long idProductoSerial;
}
