package com.aliengnss.backend.presentacion.consultas;

import java.math.BigDecimal;

public record ComisionUsuarioDto(
		  Long idUsuario,
		  String nombreUsuario,
		  String nombres,
		  java.math.BigDecimal totalVendido,
		  java.math.BigDecimal totalComision
		) {}