package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.aliengnss.backend.dominio.entidades.Venta;

public interface IVentaUseCase {

    Venta guardar(Venta venta);
    Venta buscarPorId(Long idVenta);
    List<Venta> listarTodos();
    void eliminar(Long idVenta);

    Venta buscarPorNumeroFactura(String numeroFactura);
    List<Venta> buscarPorClienteId(Long idCliente);
    List<Venta> buscarPorRangoFechas(LocalDateTime desde, LocalDateTime hasta);

    List<Venta> buscarPorUsuarioId(Long idUsuario);
    List<Venta> buscarPorClienteIdYRangoFechas(Long idCliente, LocalDateTime desde, LocalDateTime hasta);
    List<Venta> buscarPorUsuarioIdYRangoFechas(Long idUsuario, LocalDateTime desde, LocalDateTime hasta);
    List<Venta> buscarPorClienteIdYUsuarioId(Long idCliente, Long idUsuario);
    List<Venta> buscarPorClienteIdYUsuarioIdYRangoFechas(Long idCliente, Long idUsuario, LocalDateTime desde, LocalDateTime hasta);
    List<Venta> buscarPorTotalEntre(BigDecimal min, BigDecimal max);
    List<Venta> buscarPorObservaciones(String texto);
}
