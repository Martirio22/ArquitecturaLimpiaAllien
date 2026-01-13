package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetalleVentaRequestDto {
    private Long idDetalleVenta;
    @NotNull
    private Long idProductoSerial;
    @NotNull
    private Long idVenta;
    @NotNull
    private Long idProducto;
    @NotNull
    private Long idUbicacion;
    @NotNull
    private int cantidad;
    @NotNull
    private BigDecimal precioUnitario;
    @NotNull
    private BigDecimal porcentajeComision;
    @NotNull
    private BigDecimal subtotal;
}
