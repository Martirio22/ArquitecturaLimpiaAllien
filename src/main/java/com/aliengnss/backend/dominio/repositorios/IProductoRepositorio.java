package com.aliengnss.backend.dominio.repositorios;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.ProductoPrecioVenta;

public interface IProductoRepositorio {
	Producto guardar(Producto producto);
	Optional<Producto> buscarPorId(Long idProducto);
	List<Producto> listarTodos();
	void eliminar(Long idProducto);
	
	List<Producto> buscarPorSerial(boolean esConSerial);
	void cambiarPrecio(Long idProducto, BigDecimal nuevoPrecio);
	List<ProductoPrecioVenta> historialPrecios(Long idProducto);
	Optional<Producto> buscarPorNombreMarcaTipo(String nombre, String marca, String tipo);
}
