package com.aliengnss.backend.dominio.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.VentaDetalleSerial;

public interface IVentaDetalleSerialRepositorio {

	VentaDetalleSerial guardar(VentaDetalleSerial ventaDetalleSerial);

	Optional<VentaDetalleSerial> buscarPorId(Long id);

	List<VentaDetalleSerial> listarTodos();

	void eliminar(Long id);
	
	List<VentaDetalleSerial> ventasPorClienteConSerial(
		    Long idCliente,
		    LocalDateTime fechaInicio,
		    LocalDateTime fechaFin
		);
}
