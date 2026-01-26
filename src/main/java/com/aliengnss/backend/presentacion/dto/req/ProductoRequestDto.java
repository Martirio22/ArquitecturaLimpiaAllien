package com.aliengnss.backend.presentacion.dto.req;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class ProductoRequestDto {	
	
	//@Null
    private Long idProducto;

    @NotBlank
    private String nombre;

    @NotBlank
    private String foto;

    @NotBlank
    private String descripcion;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal precioVenta;

    @NotNull
    private Boolean esConSerial;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal porcentajeComision;

    //@NotNull // o @Null si lo setea el backend
    private LocalDateTime fechaCreacion;
}
