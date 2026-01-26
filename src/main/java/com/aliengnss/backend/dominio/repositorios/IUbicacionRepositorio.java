package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Usuario;


public interface IUbicacionRepositorio {
	Ubicacion guardar(Ubicacion ubicacion);

	Optional<Ubicacion> buscarPorId(Long id);

	List<Ubicacion> listarTodos();

	void eliminar(Long id);
	
	Optional<Ubicacion> buscarPorNombreExacto(String nombre);

	
	
}
