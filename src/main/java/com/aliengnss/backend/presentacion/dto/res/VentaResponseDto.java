package com.aliengnss.backend.presentacion.dto.res;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.dominio.entidades.Usuario;

@Data
public class VentaResponseDto {
    private Long idVenta;
    private String numeroFactura;
    private LocalDateTime fechaVenta;

    // NUEVOS
    private BigDecimal subtotal;
    private BigDecimal ivaPorcentaje;
    private BigDecimal ivaValor;

    private BigDecimal total;
    private String observaciones;
    private Boolean esActivo;
    private Cliente fkCliente;
    private Usuario fkUsuario;
}
