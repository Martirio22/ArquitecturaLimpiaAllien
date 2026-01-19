package com.aliengnss.backend.dominio.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.CompraProducto;

public interface ICompraProductoRepositorio {

    CompraProducto guardar(CompraProducto compra);
    Optional<CompraProducto> buscarPorId(Long idCompraProducto);
    List<CompraProducto> listarTodos();
    void eliminar(Long idCompraProducto);

    List<CompraProducto> buscarPorUsuarioId(Long idUsuario);
    List<CompraProducto> buscarPorFechaEntre(LocalDateTime desde, LocalDateTime hasta);
    List<CompraProducto> buscarPorTexto(String texto);

    List<CompraProducto> buscarPorUsuarioIdYFechaEntre(
            Long idUsuario, LocalDateTime desde, LocalDateTime hasta
    );
}
