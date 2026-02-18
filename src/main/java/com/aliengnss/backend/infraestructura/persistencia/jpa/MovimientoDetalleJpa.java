package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private int cantidad;
	@ManyToOne
    @JoinColumn(name = "idMovimiento")
	private MovimientoJpa fkMovimiento;
	@ManyToOne
    @JoinColumn(name = "idProducto")
	private ProductoJpa fkProducto;

}
