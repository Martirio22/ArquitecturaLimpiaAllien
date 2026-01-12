package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MovimientoDetalle")
public class MovimientoDetalleJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimientoDetalle;
	@Column(nullable = false)
	private int idMovimientoSeries;
	@Column(nullable = false)
	private int idMovimiento;
	@Column(nullable = false)
	private int idProducto;
	@Column(nullable = false)
	private int cantidad;

}
