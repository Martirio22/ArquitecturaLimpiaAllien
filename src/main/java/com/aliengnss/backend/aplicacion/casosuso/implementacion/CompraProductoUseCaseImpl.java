package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoUseCase;
import com.aliengnss.backend.dominio.entidades.CompraProducto;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoRepositorio;

@Service
@Transactional
public class CompraProductoUseCaseImpl implements ICompraProductoUseCase {

    private final ICompraProductoRepositorio repo;

    public CompraProductoUseCaseImpl(ICompraProductoRepositorio repo) {
        this.repo = repo;
    }

    @Override
    public CompraProducto guardar(CompraProducto compra) {
        return repo.guardar(compra);
    }

    @Override
    @Transactional(readOnly = true)
    public CompraProducto buscarPorId(Long idCompraProducto) {
        return repo.buscarPorId(idCompraProducto)
                .orElseThrow(() -> new RuntimeException("CompraProducto no encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraProducto> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    public void eliminar(Long idCompraProducto) {
        repo.eliminar(idCompraProducto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraProducto> buscarPorUsuarioId(Long idUsuario) {
        return repo.buscarPorUsuarioId(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraProducto> buscarPorFechaEntre(LocalDateTime desde, LocalDateTime hasta) {
        return repo.buscarPorFechaEntre(desde, hasta);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraProducto> buscarPorTexto(String texto) {
        return repo.buscarPorTexto(texto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraProducto> buscarPorUsuarioIdYFechaEntre(Long idUsuario,
                                                             LocalDateTime desde,
                                                             LocalDateTime hasta) {
        return repo.buscarPorUsuarioIdYFechaEntre(idUsuario, desde, hasta);
    }
}
