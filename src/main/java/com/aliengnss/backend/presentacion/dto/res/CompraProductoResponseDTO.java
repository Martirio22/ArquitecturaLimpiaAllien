package com.aliengnss.backend.presentacion.dto.res;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CompraProductoResponseDTO {

	private Long idCompraProducto;
    private Long idCompraProductoDetalle;
    private LocalDateTime fechaIngreso;
    private Long idUsuario;
    private String observaciones;
}
