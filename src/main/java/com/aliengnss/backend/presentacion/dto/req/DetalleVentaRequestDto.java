package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetalleVentaRequestDto {
    @NotBlank
    private  Long idDetalleVenta;
    @NotBlank
    private  Long idProductoSerial;
    @NotBlank
    private  Long idVenta;
    @NotBlank
    private  Long idProducto;
    @NotBlank
    private  Long idUbicacion;
    @NotBlank
    private  int cantidad;
    @NotBlank
    private  BigDecimal precioUnitario;
    @NotBlank
    private  BigDecimal porcentajeComision;
    @NotBlank
    private  BigDecimal subtotal;
}
