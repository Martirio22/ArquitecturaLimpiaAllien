package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

@Data
public class DetalleCatalogoResponseDto {

	private Long idDetalleCatalogo;
	private String codigoDetalle;
	private String descripcion;
	private double valorNumerico;
	private Long orden;
	private boolean esActivo;
	
	private Long idCatalogo;
}
