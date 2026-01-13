package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MovimientoSeries")
public class MovimientoSeriesJpa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimientoSeries;
	
	@Column(nullable = false)
	private Long idMovimientoDetalle;
	
	@Column(nullable = false)
	private Long idProductoSerial;
}
