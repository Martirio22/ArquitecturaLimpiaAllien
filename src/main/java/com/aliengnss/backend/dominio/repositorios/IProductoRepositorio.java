package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Producto;

public interface IProductoRepositorio {
	Producto guardar(Producto producto);
	Optional<Producto> buscarPorId(Long idProducto);
	List<Producto> listarTodos();
	void eliminar(Long idProducto);
}
