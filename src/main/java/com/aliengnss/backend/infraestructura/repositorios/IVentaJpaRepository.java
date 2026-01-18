package com.aliengnss.backend.infraestructura.repositorios;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ClienteJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaJpa;

public interface IVentaJpaRepository extends JpaRepository<VentaJpa, Long> {

    Optional<VentaJpa> findByNumeroFactura(String numeroFactura);

    List<VentaJpa> findByFkCliente(ClienteJpa fkCliente);

    List<VentaJpa> findByFechaVentaBetween(LocalDateTime desde, LocalDateTime hasta);

    List<VentaJpa> findByFkUsuario(UsuarioJpa fkUsuario);

    List<VentaJpa> findByFkClienteAndFechaVentaBetween(ClienteJpa fkCliente, LocalDateTime desde, LocalDateTime hasta);

    List<VentaJpa> findByFkUsuarioAndFechaVentaBetween(UsuarioJpa fkUsuario, LocalDateTime desde, LocalDateTime hasta);

    List<VentaJpa> findByFkClienteAndFkUsuario(ClienteJpa fkCliente, UsuarioJpa fkUsuario);

    List<VentaJpa> findByFkClienteAndFkUsuarioAndFechaVentaBetween(
            ClienteJpa fkCliente,
            UsuarioJpa fkUsuario,
            LocalDateTime desde,
            LocalDateTime hasta
    );

    List<VentaJpa> findByTotalBetween(BigDecimal min, BigDecimal max);

    List<VentaJpa> findByObservacionesContainingIgnoreCase(String texto);
}
