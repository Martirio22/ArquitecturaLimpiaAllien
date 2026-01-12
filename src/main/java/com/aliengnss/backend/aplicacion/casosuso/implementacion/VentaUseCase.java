package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;

import java.util.List;

public class VentaUseCase implements IVentaUseCase {

    private final IVentaRepositorio ventaRepositorio;

    public VentaUseCase(IVentaRepositorio ventaRepositorio) {
        this.ventaRepositorio = ventaRepositorio;
    }

    @Override
    public Venta guardar(Venta venta) {
        return ventaRepositorio.guardar(venta);
    }

    @Override
    public Venta buscarPorId(Long idVenta) {
        return ventaRepositorio.buscarPorId(idVenta).orElseThrow(() -> new RuntimeException("No existe el venta con el id " + idVenta));
    }

    @Override
    public List<Venta> listarTodos() {
        return ventaRepositorio.listarTodos();
    }

    @Override
    public void eliminar(Long idVenta) {
        ventaRepositorio.eliminar(idVenta);
    }
}
