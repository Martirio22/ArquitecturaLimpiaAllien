package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;


public class VentaUseCaseImpl implements IVentaUseCase {

    private final IVentaRepositorio repo;

    public VentaUseCaseImpl(IVentaRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public Venta guardar(Venta venta) {
        return repo.guardar(venta);
    }

    @Override
    @Transactional(readOnly = true)
    public Venta buscarPorId(Long idVenta) {
        return repo.buscarPorId(idVenta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada: " + idVenta));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public void eliminar(Long idVenta) {
        repo.eliminar(idVenta);
    }

    
}
