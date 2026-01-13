package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;

@Service
public class MovimientoUseCaseImpl implements IMovimientoUseCase {
	private final IMovimientoRepositorio repositorio;

	public MovimientoUseCaseImpl(IMovimientoRepositorio repositorio) {

		this.repositorio = repositorio;
	}

	@Override
	public Movimiento crear(Movimiento movimiento) {
		// TODO Auto-generated method stub
		return repositorio.guardar(movimiento);
	}

	@Override
	public Movimiento obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(id)
				.orElseThrow(()-> new RuntimeException("Movimiento no encontrado"));
	}

	@Override
	public List<Movimiento> Listar() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(Long id) {
		repositorio.eliminar(id);

	}
}
