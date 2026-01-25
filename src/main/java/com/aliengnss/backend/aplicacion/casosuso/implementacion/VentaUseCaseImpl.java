package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.time.LocalDateTime;
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
    @Transactional
    public Venta guardar(Venta venta) {
    	LocalDateTime fechaActual = LocalDateTime.now();
        
        String nuevoNumero = generarProximoNumeroFactura();
        
        Venta ventaParaGuardar = new Venta(
                null, 
                nuevoNumero, 
                fechaActual, 
                venta.getTotal(), 
                venta.getObservaciones(), 
                venta.getFkCliente(), 
                venta.getFkUsuario()
            );
        return repo.guardar(ventaParaGuardar);
    }
    private String generarProximoNumeroFactura() {
        return repo.listarTodos().stream()
            .map(Venta::getNumeroFactura)
            .max(String::compareTo)
            .map(ultimo -> {
                int num = Integer.parseInt(ultimo.split("-")[1]) + 1;
                return String.format("VNT-%04d", num);
            })
            .orElse("VNT-0001");
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
