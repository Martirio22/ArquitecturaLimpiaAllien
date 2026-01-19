package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoJpaRepository;


public class CompraProductoRepositorioImpl implements ICompraProductoRepositorio {

    private final ICompraProductoJpaRepository repoJpa;
    private final ICompraProductoJpaMapper mapper;

    public CompraProductoRepositorioImpl(ICompraProductoJpaRepository repoJpa,
                                         ICompraProductoJpaMapper mapper) {
        this.repoJpa = repoJpa;
        this.mapper = mapper;
    }

    @Override
    public CompraProducto guardar(CompraProducto compra) {
        CompraProductoJpa saved = repoJpa.save(mapper.toEntity(compra));
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CompraProducto> buscarPorId(Long idCompraProducto) {
        return repoJpa.findById(idCompraProducto).map(mapper::toDomain);
    }

    @Override
    public List<CompraProducto> listarTodos() {
        return repoJpa.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long idCompraProducto) {
        repoJpa.deleteById(idCompraProducto);
    }

    @Override
    public List<CompraProducto> buscarPorUsuarioId(Long idUsuario) {
        return repoJpa.findByFkUsuario_IdUsuario(idUsuario)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<CompraProducto> buscarPorFechaEntre(LocalDateTime desde, LocalDateTime hasta) {
        return repoJpa.findByFechaIngresoBetween(desde, hasta)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<CompraProducto> buscarPorTexto(String texto) {
        return repoJpa.findByObservacionesContainingIgnoreCase(texto)
                .stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<CompraProducto> buscarPorUsuarioIdYFechaEntre(Long idUsuario,
                                                             LocalDateTime desde,
                                                             LocalDateTime hasta) {
        return repoJpa.findByFkUsuario_IdUsuarioAndFechaIngresoBetween(idUsuario, desde, hasta)
                .stream().map(mapper::toDomain).toList();
    }
}
