package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IDetalleVentaUseCase;
import com.aliengnss.backend.dominio.entidades.DetalleVenta;
import com.aliengnss.backend.dominio.repositorios.IDetalleVentaRepositorio;

import java.util.List;

public class DetalleVentaUseCase implements IDetalleVentaUseCase {

    private final IDetalleVentaRepositorio detalleVentaRepositorio;

    public DetalleVentaUseCase(IDetalleVentaRepositorio detalleVentaRepositorio) {
        this.detalleVentaRepositorio = detalleVentaRepositorio;
    }

    @Override
    public DetalleVenta guardar(DetalleVenta detalleVenta) {
        return detalleVentaRepositorio.guardar(detalleVenta);
    }

    @Override
    public DetalleVenta buscarPorId(Long idDetalleVenta) {
        return detalleVentaRepositorio.buscarPorId(idDetalleVenta).orElseThrow(() -> new RuntimeException("DetalleVenta no encontrada"));
    }

    @Override
    public List<DetalleVenta> listarTodos() {
        return detalleVentaRepositorio.listarTodos();
    }

    @Override
    public void eliminar(Long idDetalleVenta) {
        detalleVentaRepositorio.eliminar(idDetalleVenta);
    }
}
