package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.CompraProducto;

public interface ICompraProductoRepositorio {
	CompraProducto guardar(CompraProducto compraproducto);
	Optional<CompraProducto> buscarPorId(Long idCompraProducto);
	List<CompraProducto> listarTodos();
	void eliminar(Long idCompraProducto);
}
