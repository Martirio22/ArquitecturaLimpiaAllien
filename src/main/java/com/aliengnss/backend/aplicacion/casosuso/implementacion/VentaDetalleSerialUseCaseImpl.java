package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaDetalleSerialUseCase;
import com.aliengnss.backend.dominio.entidades.VentaDetalleSerial;
import com.aliengnss.backend.dominio.repositorios.IVentaDetalleSerialRepositorio;

public class VentaDetalleSerialUseCaseImpl implements IVentaDetalleSerialUseCase {

	private final IVentaDetalleSerialRepositorio cpRepositorio;


	public VentaDetalleSerialUseCaseImpl(IVentaDetalleSerialRepositorio cpRepositorio) {
		super();
		this.cpRepositorio = cpRepositorio;
	}

	@Override
	public VentaDetalleSerial guardar(VentaDetalleSerial ventaDetalleSerial) {
		return cpRepositorio.guardar(ventaDetalleSerial);
	}

	@Override
	public VentaDetalleSerial buscarPorId(Long idVentaDetalleSerial) {
		return cpRepositorio.buscarPorId(idVentaDetalleSerial).orElseThrow(() -> new RuntimeException("Venta detalle serial no encontrado"));
	}

	@Override
	public List<VentaDetalleSerial> listarTodos() {
		return cpRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idVentaDetalleSerial) {
		cpRepositorio.eliminar(idVentaDetalleSerial);
	}

}
