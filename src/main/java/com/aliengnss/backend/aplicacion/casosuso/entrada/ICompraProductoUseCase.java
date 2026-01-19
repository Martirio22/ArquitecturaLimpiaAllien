package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.time.LocalDateTime;
import java.util.List;

import com.aliengnss.backend.dominio.entidades.CompraProducto;

public interface ICompraProductoUseCase {

    CompraProducto guardar(CompraProducto compra);
    CompraProducto buscarPorId(Long idCompraProducto);
    List<CompraProducto> listarTodos();
    void eliminar(Long idCompraProducto);

    List<CompraProducto> buscarPorUsuarioId(Long idUsuario);
    List<CompraProducto> buscarPorFechaEntre(LocalDateTime desde, LocalDateTime hasta);
    List<CompraProducto> buscarPorTexto(String texto);

    List<CompraProducto> buscarPorUsuarioIdYFechaEntre(
            Long idUsuario, LocalDateTime desde, LocalDateTime hasta
    );
}
