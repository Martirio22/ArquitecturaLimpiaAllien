package com.aliengnss.backend.presentacion.dto.req;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class MovimientoRequestDto {

	
	@Null
    private Long idMovimiento;

    @NotNull
    private LocalDateTime fechaMovimiento;

    @NotBlank
    private String tipo;

    @NotBlank
    private String observaciones;

    @NotNull
    private Usuario fkUsuario;

    @NotNull
    private Long idUbicacionOrigen;

    @NotNull
    private Long idUbicacionDestino;
}
