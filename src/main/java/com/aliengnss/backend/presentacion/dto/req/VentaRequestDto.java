package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class VentaRequestDto {
    private  Long idVenta;
    @NotNull

    private  String numeroFactura;
    @NotNull

    private  LocalDateTime fechaVenta;
    @NotNull

    private  Long idCliente;
    @NotNull

    private  Long idUsuario;
    @NotNull

    private  Long idUbicacion;
    @NotNull

    private  BigDecimal total;
    @NotNull

    private  String observaciones;
}
