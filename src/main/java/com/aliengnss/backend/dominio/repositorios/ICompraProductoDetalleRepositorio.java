package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;

public interface ICompraProductoDetalleRepositorio {

	CompraProductoDetalle guardar(CompraProductoDetalle compraproductodetalle);
	Optional<CompraProductoDetalle> buscarPorId(Long idCompraProductoDetalle);
	List<CompraProductoDetalle> listarTodos();
	void eliminar(Long idCompraProductoDetalle);
}
