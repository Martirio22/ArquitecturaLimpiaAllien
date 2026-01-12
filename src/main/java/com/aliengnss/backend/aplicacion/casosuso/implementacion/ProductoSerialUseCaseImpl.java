package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoSerialUseCase;
import com.aliengnss.backend.dominio.entidades.ProductoSerial;
import com.aliengnss.backend.dominio.repositorios.IProductoSerialRepositorio;

public class ProductoSerialUseCaseImpl implements IProductoSerialUseCase {
	
	private final IProductoSerialRepositorio productoSerialRepositorio;

	public ProductoSerialUseCaseImpl(IProductoSerialRepositorio productoSerialRepositorio) {
		this.productoSerialRepositorio = productoSerialRepositorio;
	}

	@Override
	public ProductoSerial guardar(ProductoSerial productoSerial) {
		return productoSerialRepositorio.guardar(productoSerial);
	}

	@Override
	public ProductoSerial buscarPorId(Long idProductoSerial) {
		return productoSerialRepositorio.buscarPorId(idProductoSerial).orElseThrow(() -> new RuntimeException("No existe el ProductoSerial con el id " + idProductoSerial));
	}

	@Override
	public List<ProductoSerial> listarTodos() {
		return productoSerialRepositorio.listarTodos();
	}

	@Override
	public void eliminar(Long idProductoSerial) {
		productoSerialRepositorio.eliminar(idProductoSerial);
	}
}
