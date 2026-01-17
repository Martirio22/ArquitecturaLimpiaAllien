package com.aliengnss.backend.presentacion.dto.req;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.dominio.entidades.ProductoSerial;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class VentaDetalleSerialRequestDTO {

	@Null
	private  Long idVentaDetalleSerial;
	@NotNull
	private DetalleVenta fkDetalleVenta;
	@NotNull
	private ProductoSerial fkProductoSerial;
}
