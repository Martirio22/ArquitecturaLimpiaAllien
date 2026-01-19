package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;

public interface IMovimientoJpaRepository extends JpaRepository<MovimientoJpa, Long> {

 
    List<MovimientoJpa> findByTipo(String tipo);

    List<MovimientoJpa> findByFkUsuario(UsuarioJpa fkUsuario);

    List<MovimientoJpa> findByFechaMovimientoBetween(LocalDateTime desde, LocalDateTime hasta);



    List<MovimientoJpa> findByTipoAndFechaMovimientoBetween(String tipo, LocalDateTime desde, LocalDateTime hasta);

    List<MovimientoJpa> findByFkUsuarioAndFechaMovimientoBetween(UsuarioJpa fkUsuario, LocalDateTime desde, LocalDateTime hasta);

    List<MovimientoJpa> findByFkUbicacionOrigen(UbicacionJpa fkUbicacionOrigen);

    List<MovimientoJpa> findByFkUbicacionDestino(UbicacionJpa fkUbicacionDestino);

    List<MovimientoJpa> findByFkUbicacionOrigenAndFkUbicacionDestino(UbicacionJpa origen, UbicacionJpa destino);

    List<MovimientoJpa> findByObservacionesContainingIgnoreCase(String texto);

    List<MovimientoJpa> findByFkUsuarioAndTipoAndFechaMovimientoBetween(
            UsuarioJpa fkUsuario,
            String tipo,
            LocalDateTime desde,
            LocalDateTime hasta
    );

}
