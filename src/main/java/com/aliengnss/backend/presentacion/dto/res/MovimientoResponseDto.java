package com.aliengnss.backend.presentacion.dto.res;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Usuario;

import lombok.Data;

@Data
public class MovimientoResponseDto {

	private Long idMovimiento;
	private LocalDateTime fechaMovimiento;
	private String tipo;
	private String observaciones;
	
	private Usuario fkUsuario;
	private Long idUbicacionOrigen;
    private Long idUbicacionDestino;
}
