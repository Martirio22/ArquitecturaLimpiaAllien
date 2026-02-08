package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.math.BigDecimal;
import java.util.List;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;

public interface IProductoUseCase {
	Producto guardar(Producto producto);
	Producto buscarPorId(Long idProducto);
	List<Producto> listarTodos();
	void eliminar(Long idProducto);
	
	List<Producto> buscarPorSerial(boolean esConSerial);
	void cambiarPrecio(Long idProducto, BigDecimal precioVenta);
	List<ProductoPrecioVenta> historialPrecios(Long idProducto);


}
