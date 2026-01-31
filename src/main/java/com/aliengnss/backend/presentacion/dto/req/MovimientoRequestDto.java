package com.aliengnss.backend.presentacion.dto.req;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoRequestDto {

    private Long idMovimiento;

    @NotNull(message = "La fecha del movimiento es requerida")
    private LocalDateTime fechaMovimiento;

    @NotBlank(message = "El tipo de movimiento es requerido")
    private String tipo;

    private String observaciones;

    // ✅ Cambiar de Usuario a Long
    @NotNull(message = "El usuario es requerido")
    private Long idUsuario;

    @NotNull(message = "La ubicación origen es requerida")
    private Long idUbicacionOrigen;

    @NotNull(message = "La ubicación destino es requerida")
    private Long idUbicacionDestino;

    @NotNull(message = "El movimiento debe tener al menos un producto")
    private List<MovimientoDetalleRequestDto> detalles;
}