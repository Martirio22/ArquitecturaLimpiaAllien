package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

import com.aliengnss.backend.dominio.entidades.Cliente;

@Data
public class VentaRequestDto {
    private Long idVenta;
    private String numeroFactura;

    // NUEVOS (opcionales)
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal subtotal;

    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal ivaPorcentaje;

    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal ivaValor;

    // total sigue existiendo (si lo mandas desde UI)
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal total;

    @NotBlank
    private String observaciones;

    private Boolean esActivo;

    @NotNull
    private Cliente fkCliente;
}
