package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoUseCase;
import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;

public class ProductoUseCaseImpl implements IProductoUseCase {
	
	private final IProductoRepositorio productoRepositorio;

	public ProductoUseCaseImpl(IProductoRepositorio productoRepositorio) {
		this.productoRepositorio = productoRepositorio;
	}

	@Override
	public Producto guardar(Producto producto) {
		return productoRepositorio.guardar(producto);
	}

	@Override
	public Producto buscarPorId(Long idProducto) {
		return productoRepositorio.buscarPorId(idProducto).orElseThrow(() -> new RuntimeException("No existe el producto con el id " + idProducto));
	}

	@Override
	public List<Producto> listarTodos() {
		return productoRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idProducto) {
		productoRepositorio.eliminar(idProducto);
	}

	@Override
	public List<Producto> buscarPorSerial(boolean esConSerial) {
		return productoRepositorio.buscarPorSerial(esConSerial);
	}

	
}
