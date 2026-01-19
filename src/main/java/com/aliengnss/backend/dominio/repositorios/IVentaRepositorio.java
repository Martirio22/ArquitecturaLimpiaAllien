package com.aliengnss.backend.dominio.repositorios;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Venta;

public interface IVentaRepositorio {

    Venta guardar(Venta venta);
    Optional<Venta> buscarPorId(Long idVenta);
    List<Venta> listarTodos();
    void eliminar(Long idVenta);

    // 3 básicas
    Optional<Venta> buscarPorNumeroFactura(String numeroFactura);
    List<Venta> buscarPorClienteId(Long idCliente);
    List<Venta> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta);

    // compuestas (según tu JPA repo)
    List<Venta> buscarPorUsuarioId(Long idUsuario);
    List<Venta> buscarPorClienteIdYRangoFechas(Long idCliente, LocalDateTime desde, LocalDateTime hasta);
    List<Venta> buscarPorUsuarioIdYRangoFechas(Long idUsuario, LocalDateTime desde, LocalDateTime hasta);
    List<Venta> buscarPorClienteIdYUsuarioId(Long idCliente, Long idUsuario);
    List<Venta> buscarPorClienteIdYUsuarioIdYRangoFechas(Long idCliente, Long idUsuario, LocalDateTime desde, LocalDateTime hasta);
    List<Venta> buscarPorTotalEntre(BigDecimal min, BigDecimal max);
    List<Venta> buscarPorObservaciones(String texto);
}
