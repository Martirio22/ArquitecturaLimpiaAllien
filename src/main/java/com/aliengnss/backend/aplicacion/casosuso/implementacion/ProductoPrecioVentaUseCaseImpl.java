package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoPrecioVentaUseCase;
import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;
import com.aliengnss.backend.dominio.repositorios.IProductoPrecioVentaRepositorio;

public class ProductoPrecioVentaUseCaseImpl implements IProductoPrecioVentaUseCase {
	private final IProductoPrecioVentaRepositorio repo;

	public ProductoPrecioVentaUseCaseImpl(IProductoPrecioVentaRepositorio repo) {
		super();
		this.repo = repo;
	}

	@Override
	public ProductoPrecioVenta guardarProductoPrecioVenta(ProductoPrecioVenta productoPrecioVenta) {
		return repo.guardarProductoPrecioVenta(productoPrecioVenta);
	}

	@Override
	public ProductoPrecioVenta buscarProductoPrecioVentaPorId(Long idPrecioVenta) {
		return repo.buscarProductoPrecioVentaPorId(idPrecioVenta).orElseThrow(() -> new RuntimeException("Precio Venta no encontrado: " + idPrecioVenta));
	}

	@Override
	public List<ProductoPrecioVenta> listarProductoPrecioVentas() {
		return repo.listarProductoPrecioVentas();
	}

	@Override
	public void eliminarProductoPrecioVenta(Long idPrecioVenta) {
		repo.eliminarProductoPrecioVenta(idPrecioVenta);
	}
}
