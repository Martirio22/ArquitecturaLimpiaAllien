package com.aliengnss.backend.presentacion.dto.req;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CambiarPrecioRequestDto {
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
	private BigDecimal precioVenta;
}
