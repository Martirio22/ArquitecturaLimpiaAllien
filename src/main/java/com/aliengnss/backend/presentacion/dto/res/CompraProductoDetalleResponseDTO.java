package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

@Data
public class CompraProductoDetalleResponseDTO {

	private Long idCompraProductoDetalle;
    private Long idProductoSerial;
    private Long idCompraProducto;
    private Long idProducto;
    private Long idUbicacion;
    private int cantidad;
}
