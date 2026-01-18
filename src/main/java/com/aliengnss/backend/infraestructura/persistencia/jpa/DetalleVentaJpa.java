package com.aliengnss.backend.infraestructura.persistencia.jpa;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Venta;

@Entity
@Table(name = "DetalleVenta")
@Data
public class DetalleVentaJpa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleVenta;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal porcentajeComision;
    private BigDecimal subtotal;
    @ManyToOne
    @JoinColumn(name = "idVenta")
    private VentaJpa fkVenta;
    @ManyToOne
    @JoinColumn(name = "idProducto")
    private ProductoJpa fkProducto;
    @ManyToOne
    @JoinColumn(name = "idUbicacion")
    private UbicacionJpa fkUbicacion;
}
