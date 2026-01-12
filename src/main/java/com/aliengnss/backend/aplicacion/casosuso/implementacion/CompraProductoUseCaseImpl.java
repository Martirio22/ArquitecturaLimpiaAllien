package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoUseCase;
import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoRepositorio;

public class CompraProductoUseCaseImpl implements ICompraProductoUseCase{
	
	private final ICompraProductoRepositorio cpRepositorio;

	public CompraProductoUseCaseImpl(ICompraProductoRepositorio cpRepositorio) {
		
		this.cpRepositorio = cpRepositorio;
	}

	@Override
	public CompraProducto guardar(CompraProducto compraproducto) {
		return cpRepositorio.guardar(compraproducto);
	}

	@Override
	public CompraProducto buscarPorId(Long idCompraProducto) {
		return cpRepositorio.buscarPorId(idCompraProducto).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public List<CompraProducto> listarTodos() {
		return cpRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idCompraProducto) {
		cpRepositorio.eliminar(idCompraProducto);
	}
	
	

}
