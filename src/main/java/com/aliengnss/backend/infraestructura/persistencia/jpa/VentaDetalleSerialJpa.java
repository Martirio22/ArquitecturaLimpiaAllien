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
@Table(name = "VentaDetalleSerial")
public class VentaDetalleSerialJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVentaDetalleSerial;
	@ManyToOne
    @JoinColumn(name = "idDetalleVenta")
	private DetalleVentaJpa fkDetalleVenta;
	@ManyToOne
    @JoinColumn(name = "idProductoSerial")
	private ProductoSerialJpa fkProductoSerial;

}
