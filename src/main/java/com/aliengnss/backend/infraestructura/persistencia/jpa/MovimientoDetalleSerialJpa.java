package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MovimientoSeries")
public class MovimientoDetalleSerialJpa implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMovimientoDetalleSerial;
	private Boolean esActivo;
	@ManyToOne
    @JoinColumn(name = "idMovimientoDetalle")
	private MovimientoDetalleJpa fkMovimientoDetalle;
	@ManyToOne
    @JoinColumn(name = "idProductoSerial")
	private ProductoSerialJpa fkProductoSerial;
	
	
}
