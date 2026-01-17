package com.aliengnss.backend.presentacion.dto.res;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductoResponseDto {
	private Long idProducto;
	private String nombre;
	private String foto;
	private String descripcion;
	private BigDecimal precioVenta;
	private Boolean esConSerial;
	private BigDecimal porcentajeComision;
	private LocalDateTime fechaCreacion;
}
