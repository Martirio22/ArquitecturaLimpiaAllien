package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IInventarioMovimientoUseCase;
import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;
import com.aliengnss.backend.dominio.repositorios.IInventarioMovimientoRepositorio;

public class InventarioMovimientoUseCaseImpl implements IInventarioMovimientoUseCase {
	
	private final IInventarioMovimientoRepositorio cpRepositorio;

	public InventarioMovimientoUseCaseImpl(IInventarioMovimientoRepositorio cpRepositorio) {
		super();
		this.cpRepositorio = cpRepositorio;
	}

	@Override
	public InventarioMovimiento guardar(InventarioMovimiento inventarioMovimiento) {
		return cpRepositorio.guardar(inventarioMovimiento);
	}

	@Override
	public InventarioMovimiento buscarPorId(Long idInventarioMovimiento) {
		return cpRepositorio.buscarPorId(idInventarioMovimiento).orElseThrow(() -> new RuntimeException("Inventario movimiento no encontrado"));
	}

	@Override
	public List<InventarioMovimiento> listarTodos() {
		return cpRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idInventarioMovimiento) {
		cpRepositorio.eliminar(idInventarioMovimiento);
	}

}
