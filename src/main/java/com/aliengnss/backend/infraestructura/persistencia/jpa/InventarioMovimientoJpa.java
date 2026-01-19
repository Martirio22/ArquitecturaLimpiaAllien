package com.aliengnss.backend.infraestructura.persistencia.jpa;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(
        name = "InventarioMovimiento"

)
public class InventarioMovimientoJpa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInventarioMovimiento;
	private LocalDateTime fecha;
	private String tipo;
	private int cantidadEntrada;
	private int cantidadSalida;
	private String referenciaTipo;
	private int referenciaId;
	@ManyToOne
    @JoinColumn(name = "idProducto")
	private ProductoJpa fkProducto;
	@ManyToOne
    @JoinColumn(name = "idProductoSerial")
	private ProductoSerialJpa fkProductoSerial;
	@ManyToOne
    @JoinColumn(name = "idUbicacion")
	private UbicacionJpa fkUbicacion;

}
