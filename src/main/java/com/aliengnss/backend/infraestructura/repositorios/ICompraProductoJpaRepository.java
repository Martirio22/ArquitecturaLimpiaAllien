package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;

public interface ICompraProductoJpaRepository extends JpaRepository<CompraProductoJpa, Long> {

    List<CompraProductoJpa> findByFkUsuario(UsuarioJpa fkUsuario);

    List<CompraProductoJpa> findByFechaIngresoBetween(LocalDateTime desde, LocalDateTime hasta);

    List<CompraProductoJpa> findByObservacionesContainingIgnoreCase(String texto);



    List<CompraProductoJpa> findByFkUsuarioAndFechaIngresoBetween(
            UsuarioJpa fkUsuario, LocalDateTime desde, LocalDateTime hasta
    );

    List<CompraProductoJpa> findByFkUsuarioAndObservacionesContainingIgnoreCase(
            UsuarioJpa fkUsuario, String texto
    );

    List<CompraProductoJpa> findByFechaIngresoGreaterThanEqual(LocalDateTime desde);

    List<CompraProductoJpa> findByFechaIngresoLessThanEqual(LocalDateTime hasta);

    List<CompraProductoJpa> findByFkUsuarioOrObservacionesContainingIgnoreCase(
            UsuarioJpa fkUsuario, String texto
    );

    List<CompraProductoJpa> findByFkUsuario_IdUsuario(Long idUsuario);

    List<CompraProductoJpa> findByFkUsuario_IdUsuarioAndFechaIngresoBetween(
            Long idUsuario, LocalDateTime desde, LocalDateTime hasta
    );
}
