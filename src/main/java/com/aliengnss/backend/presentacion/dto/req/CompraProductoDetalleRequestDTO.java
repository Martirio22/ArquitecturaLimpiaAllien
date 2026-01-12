package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CompraProductoDetalleRequestDTO {

	private Long idCompraProductoDetalle;
	
    private Long idProductoSerial;
	@NotNull
    private Long idCompraProducto;
	@NotNull
    private Long idProducto;
	@NotNull
    private Long idUbicacion;
	@Min(1)
	@Max(1_000_000)
	private int cantidad;

}
