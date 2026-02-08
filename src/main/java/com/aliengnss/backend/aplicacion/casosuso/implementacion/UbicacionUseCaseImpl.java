package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;



public class UbicacionUseCaseImpl implements IUbicacionUseCase {
	private final IUbicacionRepositorio repositorio;

	public UbicacionUseCaseImpl(IUbicacionRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	@Transactional
	public Ubicacion crear(Ubicacion ubicacion) {
	    Ubicacion ubicacionParaGuardar;

	    if (ubicacion.getIdUbicacion() == null) {
	        // --- CREAR ---
	        ubicacionParaGuardar = new Ubicacion(
	            null,
	            ubicacion.getNombre(),
	            ubicacion.getTipo(),
	            ubicacion.getDescripcion(),
	            true,                       // siempre activo al nacer
	            ubicacion.getEsPuntoVenta() // NUEVO
	        );
	    } else {
	        // --- ACTUALIZAR ---
	        Ubicacion existente = obtenerPorId(ubicacion.getIdUbicacion());

	        ubicacionParaGuardar = new Ubicacion(
	            existente.getIdUbicacion(),
	            ubicacion.getNombre(),
	            ubicacion.getTipo(),
	            ubicacion.getDescripcion(),
	            existente.getEsActivo(),     // mantiene estado actual
	            ubicacion.getEsPuntoVenta()  // NUEVO (o existente si no quieres permitir cambiarlo)
	        );
	    }

	    return repositorio.guardar(ubicacionParaGuardar);
	}
	@Override
	public Ubicacion obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(id)
				.orElseThrow(()-> new RuntimeException("Ubicacion no encontrado"));
	}

	@Override
	public List<Ubicacion> Listar() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
	    Ubicacion existente = obtenerPorId(id);

	    Ubicacion ubicacionDesactivada = new Ubicacion(
	        existente.getIdUbicacion(),
	        existente.getNombre(),
	        existente.getTipo(),
	        existente.getDescripcion(),
	        false,                   // desactivado
	        existente.getEsPuntoVenta() // NUEVO: no cambies este flag al eliminar
	    );

	    repositorio.guardar(ubicacionDesactivada);
	}
}
