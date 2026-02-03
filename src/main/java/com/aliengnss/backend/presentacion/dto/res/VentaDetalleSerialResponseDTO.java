package com.aliengnss.backend.presentacion.dto.res;

import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.dominio.entidades.ProductoSerial;

import lombok.Data;

@Data
public class VentaDetalleSerialResponseDTO {

	private Long idVentaDetalleSerial;
	private Boolean esActivo;
	private DetalleVenta fkDetalleVenta;
	private ProductoSerial fkProductoSerial;
}
