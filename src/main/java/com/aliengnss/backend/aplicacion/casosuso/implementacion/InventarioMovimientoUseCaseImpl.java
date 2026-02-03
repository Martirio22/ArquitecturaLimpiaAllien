package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.time.LocalDateTime;
import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IInventarioMovimientoUseCase;
import com.aliengnss.backend.aplicacion.casosuso.excepciones.StockInsuficienteException;
import com.aliengnss.backend.dominio.entidades.InventarioMovimiento;
import com.aliengnss.backend.dominio.repositorios.IInventarioMovimientoRepositorio;

import jakarta.transaction.Transactional;

public class InventarioMovimientoUseCaseImpl implements IInventarioMovimientoUseCase {
	
	private final IInventarioMovimientoRepositorio cpRepositorio;

	public InventarioMovimientoUseCaseImpl(IInventarioMovimientoRepositorio cpRepositorio) {
		super();
		this.cpRepositorio = cpRepositorio;
	}


	@Override
	@Transactional
	public InventarioMovimiento guardar(InventarioMovimiento mov) {
		
		// 1. Lógica de validación de Stock para SALIDAS (Se mantiene igual)
		if (mov.getCantidadSalida() > 0) {
			Integer stockActual = cpRepositorio.obtenerStockPorProductoYUbicacion(
				mov.getFkProducto().getIdProducto(), 
				mov.getFkUbicacion().getIdUbicacion()
			);

			if (stockActual == null || stockActual < mov.getCantidadSalida()) {
				throw new StockInsuficienteException(
					"Stock insuficiente. Disponible: " + (stockActual == null ? 0 : stockActual) + 
					", Solicitado: " + mov.getCantidadSalida()
				);
			}
		}

		InventarioMovimiento movimientoParaGuardar;

		if (mov.getIdInventarioMovimiento() == null) {
			// --- NUEVO MOVIMIENTO ---
			movimientoParaGuardar = new InventarioMovimiento(
				null, 
				LocalDateTime.now(), // Sellamos fecha actual
				mov.getTipo(), 
				mov.getCantidadEntrada(),
				mov.getCantidadSalida(), 
				mov.getReferenciaTipo(), 
				mov.getReferenciaId(), 
				true, // <--- ACTIVO POR DEFECTO
				mov.getFkProducto(),
				mov.getFkProductoSerial(), 
				mov.getFkUbicacion()
			);
		} else {
			// --- EDICIÓN DE MOVIMIENTO ---
			InventarioMovimiento existente = buscarPorId(mov.getIdInventarioMovimiento());
			movimientoParaGuardar = new InventarioMovimiento(
				existente.getIdInventarioMovimiento(), 
				existente.getFecha(), // Mantenemos fecha original
				mov.getTipo(), 
				mov.getCantidadEntrada(),
				mov.getCantidadSalida(), 
				mov.getReferenciaTipo(), 
				mov.getReferenciaId(), 
				existente.getEsActivo(), // <--- MANTENEMOS ESTADO ACTUAL
				mov.getFkProducto(),
				mov.getFkProductoSerial(), 
				mov.getFkUbicacion()
			);
		}

		return cpRepositorio.guardar(movimientoParaGuardar);
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
	@Transactional
	public void eliminar(Long idInventarioMovimiento) {
		// Borrado lógico
		InventarioMovimiento existente = buscarPorId(idInventarioMovimiento);
		
		InventarioMovimiento desactivado = new InventarioMovimiento(
			existente.getIdInventarioMovimiento(), 
			existente.getFecha(), 
			existente.getTipo(), 
			existente.getCantidadEntrada(),
			existente.getCantidadSalida(), 
			existente.getReferenciaTipo(), 
			existente.getReferenciaId(), 
			false, // <--- DESACTIVADO
			existente.getFkProducto(),
			existente.getFkProductoSerial(), 
			existente.getFkUbicacion()
		);
		
		cpRepositorio.guardar(desactivado);
	}

	@Override
	public List<InventarioMovimiento> buscarPorProductoYTipo(Long idProducto, String tipo) {
		return cpRepositorio.buscarPorProductoYTipo(idProducto, tipo);
	}

	@Override
	public List<InventarioMovimiento> buscarPorUbicacionTipoYFecha(Long idUbicacion, String tipo,
			LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		return cpRepositorio.buscarPorUbicacionTipoYFecha(idUbicacion, tipo, fechaInicio, fechaFin);
	}

	@Override
	public List<InventarioMovimiento> buscarMovimientoPorSerial(String serial) {
		return cpRepositorio.buscarMovimientoPorSerial(serial);
	}

	@Override
	public Integer obtenerStockPorProductoYUbicacion(Long idProducto, Long idUbicacion) {
		return cpRepositorio.obtenerStockPorProductoYUbicacion(idProducto, idUbicacion);
	}

	
}
