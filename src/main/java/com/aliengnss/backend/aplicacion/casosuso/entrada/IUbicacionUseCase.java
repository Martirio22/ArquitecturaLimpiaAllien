package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Ubicacion;


public interface IUbicacionUseCase {
	Ubicacion guardar(Ubicacion ubicacion);

	Ubicacion obtenerPorId(Long id);

	List<Ubicacion> Listar();

	void eliminar(Long id);
	
	Optional<Ubicacion> findByNombre(String nombre);
}
