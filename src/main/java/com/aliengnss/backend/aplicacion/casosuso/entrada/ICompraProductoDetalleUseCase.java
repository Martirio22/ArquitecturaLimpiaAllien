package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.math.BigDecimal;
import java.util.List;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;

public interface ICompraProductoDetalleUseCase {

    CompraProductoDetalle guardar(CompraProductoDetalle detalle);
    CompraProductoDetalle buscarPorId(Long idCompraProductoDetalle);
    List<CompraProductoDetalle> listarTodos();
    void eliminar(Long idCompraProductoDetalle);

    List<CompraProductoDetalle> buscarPorCompraProductoId(Long idCompraProducto);
    CompraProductoDetalle buscarPorCompraProductoIdYProductoId(Long idCompraProducto, Long idProducto);

    List<CompraProductoDetalle> buscarPorCompraProductoIdYCantidadMayor(Long idCompraProducto, int cantidad);
    List<CompraProductoDetalle> buscarPorCompraProductoIdYCostoEntre(Long idCompraProducto, BigDecimal min, BigDecimal max);
}
