package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoDetalleUseCase;
import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoDetalleRepositorio;

public class CompraProductoDetalleUseCaseImpl implements ICompraProductoDetalleUseCase{

	private final ICompraProductoDetalleRepositorio cpdRepositorio;
	
	public CompraProductoDetalleUseCaseImpl(ICompraProductoDetalleRepositorio cpdRepositorio) {
		
		this.cpdRepositorio = cpdRepositorio;
	}

	@Override
	public CompraProductoDetalle guardar(CompraProductoDetalle compraproductodetalle) {
		return cpdRepositorio.guardar(compraproductodetalle);
	}

	@Override
	public CompraProductoDetalle buscarPorId(Long idCompraProductoDetalle) {
		return cpdRepositorio.buscarPorId(idCompraProductoDetalle).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public List<CompraProductoDetalle> listarTodos() {
		return cpdRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idCompraProductoDetalle) {
		cpdRepositorio.eliminar(idCompraProductoDetalle);
	}

}
