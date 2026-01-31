package com.aliengnss.backend.presentacion.dto.req;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovimientoDetalleRequestDto {
    
    @NotNull(message = "El ID del producto es requerido")
    private Long idProducto;
    
    @NotNull(message = "La cantidad es requerida")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer cantidad;
}