package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;

public interface IProductoPrecioVentaUseCase {
	ProductoPrecioVenta guardarProductoPrecioVenta(ProductoPrecioVenta productoPrecioVenta);
	ProductoPrecioVenta buscarProductoPrecioVentaPorId(Long idPrecioVenta);
	List<ProductoPrecioVenta> listarProductoPrecioVentas();
	void eliminarProductoPrecioVenta(Long idPrecioVenta);
	
}
