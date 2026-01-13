package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.CompraProducto;

public interface ICompraProductoUseCase {

	CompraProducto guardar(CompraProducto compraproducto);
	CompraProducto buscarPorId(Long idCompraProducto);
	List<CompraProducto> listarTodos();
	void eliminar(Long idCompraProducto);
}
