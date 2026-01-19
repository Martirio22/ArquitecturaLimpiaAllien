package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
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

    @Override
    @Transactional(readOnly = true)
    public Venta buscarPorNumeroFactura(String numeroFactura) {
        return repo.buscarPorNumeroFactura(numeroFactura)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada por factura: " + numeroFactura));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorClienteId(Long idCliente) {
        return repo.buscarPorClienteId(idCliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorRangoFechas(desde, hasta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorUsuarioId(Long idUsuario) {
        return repo.buscarPorUsuarioId(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorClienteIdYRangoFechas(Long idCliente, LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorClienteIdYRangoFechas(idCliente, desde, hasta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorUsuarioIdYRangoFechas(Long idUsuario, LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorUsuarioIdYRangoFechas(idUsuario, desde, hasta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorClienteIdYUsuarioId(Long idCliente, Long idUsuario) {
        return repo.buscarPorClienteIdYUsuarioId(idCliente, idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorClienteIdYUsuarioIdYRangoFechas(Long idCliente, Long idUsuario, LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorClienteIdYUsuarioIdYRangoFechas(idCliente, idUsuario, desde, hasta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorTotalEntre(BigDecimal min, BigDecimal max) {
        return repo.buscarPorTotalEntre(min, max);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarPorObservaciones(String texto) {
        return repo.buscarPorObservaciones(texto);
    }
}
