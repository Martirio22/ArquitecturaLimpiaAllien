package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Ubicacion;


public interface IUbicacionRepositorio {
	Ubicacion guardar(Ubicacion ubicacion);

	Optional<Ubicacion> buscarPorId(Long id);

	List<Ubicacion> listarTodos();

	void eliminar(Long id);
	
	// NUEVOS:
    List<Ubicacion> buscarPorTipo(String tipo);
    List<Ubicacion> buscarPorNombre(String nombre);
    List<Ubicacion> buscarPorTipoYNombre(String tipo, String nombre);
}
