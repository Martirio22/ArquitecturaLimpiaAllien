package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ClienteJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IVentaJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IVentaJpaRepository;


public class VentaRepositorioImpl implements IVentaRepositorio {

    private final IVentaJpaRepository ventaJpaRepository;
    private final IVentaJpaMapper mapper;

    public VentaRepositorioImpl(IVentaJpaRepository ventaJpaRepository, IVentaJpaMapper mapper) {
        this.ventaJpaRepository = ventaJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Venta guardar(Venta venta) {
        return mapper.toDomain(ventaJpaRepository.save(mapper.toEntity(venta)));
    }

    @Override
    public Optional<Venta> buscarPorId(Long idVenta) {
        return ventaJpaRepository.findById(idVenta).map(mapper::toDomain);
    }

    @Override
    public List<Venta> listarTodos() {
        return ventaJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long idVenta) {
        ventaJpaRepository.deleteById(idVenta);
    }

    @Override
    public Optional<Venta> buscarPorNumeroFactura(String numeroFactura) {
        return ventaJpaRepository.findByNumeroFactura(numeroFactura).map(mapper::toDomain);
    }

    @Override
    public List<Venta> buscarPorClienteId(Long idCliente) {
        ClienteJpa clienteRef = new ClienteJpa();
        clienteRef.setIdCliente(idCliente);
        return ventaJpaRepository.findByFkCliente(clienteRef).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Venta> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta) {
        return ventaJpaRepository.findByFechaVentaBetween(desde, hasta).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Venta> buscarPorUsuarioId(Long idUsuario) {
        UsuarioJpa usuarioRef = new UsuarioJpa();
        usuarioRef.setIdUsuario(idUsuario);
        return ventaJpaRepository.findByFkUsuario(usuarioRef).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Venta> buscarPorClienteIdYRangoFechas(Long idCliente, LocalDateTime desde, LocalDateTime hasta) {
        ClienteJpa clienteRef = new ClienteJpa();
        clienteRef.setIdCliente(idCliente);
        return ventaJpaRepository.findByFkClienteAndFechaVentaBetween(clienteRef, desde, hasta)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Venta> buscarPorUsuarioIdYRangoFechas(Long idUsuario, LocalDateTime desde, LocalDateTime hasta) {
        UsuarioJpa usuarioRef = new UsuarioJpa();
        usuarioRef.setIdUsuario(idUsuario);
        return ventaJpaRepository.findByFkUsuarioAndFechaVentaBetween(usuarioRef, desde, hasta)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Venta> buscarPorClienteIdYUsuarioId(Long idCliente, Long idUsuario) {
        ClienteJpa clienteRef = new ClienteJpa();
        clienteRef.setIdCliente(idCliente);
        UsuarioJpa usuarioRef = new UsuarioJpa();
        usuarioRef.setIdUsuario(idUsuario);

        return ventaJpaRepository.findByFkClienteAndFkUsuario(clienteRef, usuarioRef)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Venta> buscarPorClienteIdYUsuarioIdYRangoFechas(Long idCliente, Long idUsuario, LocalDateTime desde, LocalDateTime hasta) {
        ClienteJpa clienteRef = new ClienteJpa();
        clienteRef.setIdCliente(idCliente);
        UsuarioJpa usuarioRef = new UsuarioJpa();
        usuarioRef.setIdUsuario(idUsuario);

        return ventaJpaRepository.findByFkClienteAndFkUsuarioAndFechaVentaBetween(clienteRef, usuarioRef, desde, hasta)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Venta> buscarPorTotalEntre(BigDecimal min, BigDecimal max) {
        return ventaJpaRepository.findByTotalBetween(min, max).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<Venta> buscarPorObservaciones(String texto) {
        return ventaJpaRepository.findByObservacionesContainingIgnoreCase(texto).stream().map(mapper::toDomain).toList();
    }
}
