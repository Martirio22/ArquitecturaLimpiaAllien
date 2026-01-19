package com.aliengnss.backend.dominio.repositorios;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;

public interface ICompraProductoDetalleRepositorio {

    CompraProductoDetalle guardar(CompraProductoDetalle detalle);
    Optional<CompraProductoDetalle> buscarPorId(Long idCompraProductoDetalle);
    List<CompraProductoDetalle> listarTodos();
    void eliminar(Long idCompraProductoDetalle);

    List<CompraProductoDetalle> buscarPorCompraProductoId(Long idCompraProducto);
    Optional<CompraProductoDetalle> buscarPorCompraProductoIdYProductoId(Long idCompraProducto, Long idProducto);

    List<CompraProductoDetalle> buscarPorCompraProductoIdYCantidadMayor(Long idCompraProducto, int cantidad);
    List<CompraProductoDetalle> buscarPorCompraProductoIdYCostoEntre(Long idCompraProducto, BigDecimal min, BigDecimal max);
}
