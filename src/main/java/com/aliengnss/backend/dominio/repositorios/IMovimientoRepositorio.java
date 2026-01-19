package com.aliengnss.backend.dominio.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Movimiento;

public interface IMovimientoRepositorio {

    Movimiento guardar(Movimiento movimiento);
    Optional<Movimiento> buscarPorId(Long idMovimiento);
    List<Movimiento> listarTodos();
    void eliminar(Long idMovimiento);

    // básicas
    List<Movimiento> buscarPorTipo(String tipo);
    List<Movimiento> buscarPorUsuarioId(Long idUsuario);
    List<Movimiento> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta);

    // compuestas
    List<Movimiento> buscarPorTipoYRangoFechas(String tipo, LocalDateTime desde, LocalDateTime hasta);
    List<Movimiento> buscarPorUsuarioIdYRangoFechas(Long idUsuario, LocalDateTime desde, LocalDateTime hasta);
    List<Movimiento> buscarPorUbicacionOrigenId(Long idUbicacionOrigen);
    List<Movimiento> buscarPorUbicacionDestinoId(Long idUbicacionDestino);
    List<Movimiento> buscarPorUbicacionOrigenIdYDestinoId(Long idUbicacionOrigen, Long idUbicacionDestino);
    List<Movimiento> buscarPorObservaciones(String texto);
    List<Movimiento> buscarPorUsuarioIdTipoYRangoFechas(Long idUsuario, String tipo, LocalDateTime desde, LocalDateTime hasta);
}
