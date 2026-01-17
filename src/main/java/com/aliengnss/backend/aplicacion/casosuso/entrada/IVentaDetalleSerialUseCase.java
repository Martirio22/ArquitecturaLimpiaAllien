package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.VentaDetalleSerial;

public interface IVentaDetalleSerialUseCase {

	VentaDetalleSerial guardar(VentaDetalleSerial ventaDetalleSerial);
	VentaDetalleSerial buscarPorId(Long idVentaDetalleSerial);
	List<VentaDetalleSerial> listarTodos();
	void eliminar(Long idVentaDetalleSerial);
}
