package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;

public interface ICompraProductoDetalleUseCase {

	CompraProductoDetalle guardar(CompraProductoDetalle compraproductodetalle);
	CompraProductoDetalle buscarPorId(Long idCompraProductoDetalle);
	List<CompraProductoDetalle> listarTodos();
	void eliminar(Long idCompraProductoDetalle);
}
