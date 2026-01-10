package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@Data
public class VentaResponseDto {
    private  Long idVenta;
    private  String numeroFactura;
    private  Date fechaVenta;
    private  Long idCliente;
    private  Long idUsuario;
    private  Long idUbicacion;
    private  BigDecimal total;
    private  String observaciones;
}
