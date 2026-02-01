package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;

public interface IMovimientoJpaRepository extends JpaRepository<MovimientoJpa, Long> {

    @Query("SELECT DISTINCT m FROM MovimientoJpa m " +
           "LEFT JOIN FETCH m.detalles d " +
           "LEFT JOIN FETCH d.fkProducto " +
           "LEFT JOIN FETCH m.fkUsuario")
    List<MovimientoJpa> findAllWithDetalles();
}