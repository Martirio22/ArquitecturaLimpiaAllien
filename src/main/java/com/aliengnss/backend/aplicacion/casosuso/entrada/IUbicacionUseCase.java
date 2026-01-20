package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Ubicacion;

public interface IUbicacionUseCase {
	Ubicacion crear(Ubicacion ubicacion);

	Ubicacion obtenerPorId(Long id);

	List<Ubicacion> Listar();

	void eliminar(Long id);
	
	// NUEVOS:
    List<Ubicacion> buscarPorTipo(String tipo);
    List<Ubicacion> buscarPorNombre(String nombre);
    List<Ubicacion> buscarPorTipoYNombre(String tipo, String nombre);
}
