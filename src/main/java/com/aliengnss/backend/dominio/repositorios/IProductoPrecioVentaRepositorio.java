package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;

public interface IProductoPrecioVentaRepositorio {
	ProductoPrecioVenta guardarProductoPrecioVenta(ProductoPrecioVenta productoPrecioVenta);
	Optional<ProductoPrecioVenta> buscarProductoPrecioVentaPorId(Long idPrecioVenta);
	List<ProductoPrecioVenta> listarProductoPrecioVentas();
	void eliminarProductoPrecioVenta(Long idPrecioVenta);

}
