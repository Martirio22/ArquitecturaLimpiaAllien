package com.aliengnss.backend.presentacion.dto.res;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class DetalleCatalogoResponseDto {

	private Long idDetalleCatalogo;
	private String codigoDetalle;
	private String descripcion;
	private double valorNumerico;
	private Long orden;
	private boolean esActivo;
	private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
	
	private Long idCatalogo;
}
