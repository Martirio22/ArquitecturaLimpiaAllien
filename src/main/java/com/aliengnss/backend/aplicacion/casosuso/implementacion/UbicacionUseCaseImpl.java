package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;



public class UbicacionUseCaseImpl implements IUbicacionUseCase {
	private final IUbicacionRepositorio repositorio;

	public UbicacionUseCaseImpl(IUbicacionRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public Ubicacion crear(Ubicacion ubicacion) {
		// TODO Auto-generated method stub
		return repositorio.guardar(ubicacion);
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
		repositorio.eliminar(id);

	}

	

}
