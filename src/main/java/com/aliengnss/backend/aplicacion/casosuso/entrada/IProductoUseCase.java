package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Producto;

public interface IProductoUseCase {
	Producto guardar(Producto producto);
	Producto buscarPorId(Long idProducto);
	List<Producto> listarTodos();
	void eliminar(Long idProducto);
}
