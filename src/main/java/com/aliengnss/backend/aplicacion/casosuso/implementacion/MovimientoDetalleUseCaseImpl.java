package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;

@Service
public class MovimientoDetalleUseCaseImpl implements IMovimientoDetalleUseCase {
	private final IMovimientoDetalleRepositorio repositorio;

	public MovimientoDetalleUseCaseImpl(IMovimientoDetalleRepositorio repositorio) {

		this.repositorio = repositorio;
	}

	@Override
	public MovimientoDetalle crear(MovimientoDetalle movimientoDetalle) {
		// TODO Auto-generated method stub
		return repositorio.guardar(movimientoDetalle);
	}

	@Override
	public MovimientoDetalle obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("MovimientoDetalle no encontrado"));
	}

	@Override
	public List<MovimientoDetalle> Listar() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(Long id) {
		repositorio.eliminar(id);

	}

}
