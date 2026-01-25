package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

import com.aliengnss.backend.dominio.entidades.Cliente;

@Data
public class VentaRequestDto {
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal total;
    @NotBlank
    private String observaciones;
    @NotNull
    private Cliente fkCliente;
}
