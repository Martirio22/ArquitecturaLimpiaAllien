package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoDetalleUseCase;
import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoDetalleRepositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompraProductoDetalleUseCaseImpl implements ICompraProductoDetalleUseCase {

    private final ICompraProductoDetalleRepositorio repo;

    public CompraProductoDetalleUseCaseImpl(ICompraProductoDetalleRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public CompraProductoDetalle guardar(CompraProductoDetalle detalle) {
        return repo.guardar(detalle);
    }

    @Override
    public CompraProductoDetalle buscarPorId(Long id) {
        return repo.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Detalle no encontrado"));
    }

    @Override
    public List<CompraProductoDetalle> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public void eliminar(Long id) {
        repo.eliminar(id);
    }

    @Override
    public List<CompraProductoDetalle> buscarPorCompraProductoId(Long idCompraProducto) {
        return repo.buscarPorCompraProductoId(idCompraProducto);
    }

    @Override
    public CompraProductoDetalle buscarPorCompraProductoIdYProductoId(Long idCompraProducto, Long idProducto) {
        return repo.buscarPorCompraProductoIdYProductoId(idCompraProducto, idProducto)
                .orElseThrow(() -> new RuntimeException("No existe detalle para compra/producto"));
    }

    @Override
    public List<CompraProductoDetalle> buscarPorCompraProductoIdYCantidadMayor(Long idCompraProducto, int cantidad) {
        return repo.buscarPorCompraProductoIdYCantidadMayor(idCompraProducto, cantidad);
    }

    @Override
    public List<CompraProductoDetalle> buscarPorCompraProductoIdYCostoEntre(Long idCompraProducto,
                                                                           BigDecimal min,
                                                                           BigDecimal max) {
        return repo.buscarPorCompraProductoIdYCostoEntre(idCompraProducto, min, max);
    }
}
