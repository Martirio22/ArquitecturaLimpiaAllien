package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class VentaRequestDto {
    @NotBlank
    private  Long idVenta;
    @NotBlank
    private  String numeroFactura;
    @NotBlank
    private  Date fechaVenta;
    @NotBlank
    private  Long idCliente;
    @NotBlank
    private  Long idUsuario;
    @NotBlank
    private  Long idUbicacion;
    @NotBlank
    private  BigDecimal total;
    @NotBlank
    private  String observaciones;
}
