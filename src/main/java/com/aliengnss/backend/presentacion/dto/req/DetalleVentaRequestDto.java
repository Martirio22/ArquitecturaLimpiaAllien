package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.math.BigDecimal;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Venta;

@Data
public class DetalleVentaRequestDto {
	@Null
	private Long idDetalleVenta;
	@NotNull
    private int cantidad;
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal precioUnitario;
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal porcentajeComision;
	@NotNull
	@DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal subtotal;
	private Boolean esActivo;
    @NotNull
    private Venta fkVenta;
    @NotNull
    private Producto fkProducto;
    @NotNull
    private Ubicacion fkUbicacion;
}
