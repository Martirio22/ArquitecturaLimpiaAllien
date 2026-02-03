package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

import java.math.BigDecimal;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Venta;

@Data
public class DetalleVentaResponseDto {
	private Long idDetalleVenta;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal porcentajeComision;
    private BigDecimal subtotal;
    private Boolean esActivo;
    private Venta fkVenta;
    private Producto fkProducto;
    private Ubicacion fkUbicacion;
}
