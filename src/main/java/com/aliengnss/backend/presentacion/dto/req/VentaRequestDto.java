package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.dominio.entidades.Usuario;

@Data
public class VentaRequestDto {
    @Null
    private Long idVenta;
    @NotBlank
    private String numeroFactura;
    @NotNull
    private LocalDateTime fechaVenta;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal total;
    @NotBlank
    private String observaciones;
    @NotNull
    private Cliente fkCliente;
    @NotNull
    private Usuario fkUsuario;
}
