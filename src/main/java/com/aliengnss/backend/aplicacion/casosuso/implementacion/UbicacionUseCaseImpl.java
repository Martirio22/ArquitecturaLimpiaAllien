package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.aliengnss.backend.dominio.entidades.Ubicacion;

import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;



public class UbicacionUseCaseImpl implements IUbicacionUseCase {
	private final IUbicacionRepositorio repositorio;

	public UbicacionUseCaseImpl(IUbicacionRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public Ubicacion guardar(Ubicacion ubicacion) {
	    if (ubicacion.getIdUbicacion() != null) {
	        // Si el ID viene, actualizar por ID
	        Optional<Ubicacion> existente = repositorio.buscarPorId(ubicacion.getIdUbicacion());
	        if (existente.isPresent()) {
	            Ubicacion actualizada = new Ubicacion(
	                ubicacion.getIdUbicacion(),
	                ubicacion.getNombre(),
	                ubicacion.getTipo(),
	                ubicacion.getDescripcion()
	            );
	            return repositorio.guardar(actualizada);
	        } else {
	            throw new RuntimeException("Ubicación no encontrada para actualizar");
	        }
	    } else {
	        // Si no viene ID, crear nuevo
	        Optional<Ubicacion> existenteNombre = repositorio.buscarPorNombreExacto(ubicacion.getNombre());
	        if (existenteNombre.isPresent()) {
	            throw new RuntimeException("Ubicación con ese nombre ya existe");
	        }
	        return repositorio.guardar(ubicacion);
	    }
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
	public void eliminar(Long id) {
		 Ubicacion ubicacion = repositorio.buscarPorId(id)
			        .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));

			    repositorio.eliminar(id);

	}

	@Override
	public Optional<Ubicacion> findByNombre(String nombre) {
		  return repositorio.buscarPorNombreExacto(nombre);
	}

	

	

}
