package com.aliengnss.backend.presentacion.dto.res;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductoPrecioVentaResponseDTO {

	private Long idPrecioVenta;
	private Long idProducto;
	private BigDecimal precioVenta;
	private LocalDateTime desde;
	private LocalDateTime hasta;
}
