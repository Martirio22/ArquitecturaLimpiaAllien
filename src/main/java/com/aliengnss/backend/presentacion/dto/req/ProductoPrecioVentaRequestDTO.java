package com.aliengnss.backend.presentacion.dto.req;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.aliengnss.backend.presentacion.dto.res.DetalleCatalogoResponseDto;

import lombok.Data;

@Data
public class ProductoPrecioVentaRequestDTO {
	private Long idPrecioVenta;
	private Long idProducto;
	private BigDecimal precioVenta;
	private LocalDateTime desde;
	private LocalDateTime hasta;

}
