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
	    
	    // 1. Si es un movimiento de SALIDA, validamos stock
	    if (mov.getCantidadSalida() > 0) {
	        Integer stockActual = cpRepositorio.obtenerStockPorProductoYUbicacion(
	            mov.getFkProducto().getIdProducto(), 
	            mov.getFkUbicacion().getIdUbicacion()
	        );

	        // Si el stock es nulo o menor a lo que se quiere sacar
	        if (stockActual == null || stockActual < mov.getCantidadSalida()) {
	            throw new StockInsuficienteException(
	                "Stock insuficiente. Disponible: " + (stockActual == null ? 0 : stockActual) + 
	                ", Solicitado: " + mov.getCantidadSalida()
	            );
	        }
	    }

	    // 2. Si pasa la validación (o es una entrada), sellamos fecha y guardamos
	    LocalDateTime fechaActual = LocalDateTime.now();
	    
	    InventarioMovimiento movimientoParaGuardar = new InventarioMovimiento(
	        null, 
	        fechaActual, 
	        mov.getTipo(), 
	        mov.getCantidadEntrada(),
	        mov.getCantidadSalida(), 
	        mov.getReferenciaTipo(), 
	        mov.getReferenciaId(), 
	        mov.getFkProducto(),
	        mov.getFkProductoSerial(), 
	        mov.getFkUbicacion()
	    );

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
	public void eliminar(Long idInventarioMovimiento) {
		cpRepositorio.eliminar(idInventarioMovimiento);
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
