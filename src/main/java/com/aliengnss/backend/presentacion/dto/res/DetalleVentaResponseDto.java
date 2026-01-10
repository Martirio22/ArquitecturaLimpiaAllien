package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetalleVentaResponseDto {
    private  Long idDetalleVenta;
    private  Long idProductoSerial;
    private  Long idVenta;
    private  Long idProducto;
    private  Long idUbicacion;
    private  int cantidad;
    private  BigDecimal precioUnitario;
    private  BigDecimal porcentajeComision;
    private  BigDecimal subtotal;
}
