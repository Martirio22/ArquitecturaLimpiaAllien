package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleSerialJpa;

public interface IMovimientoSeriesJpaRepository extends JpaRepository<MovimientoDetalleSerialJpa, Long> {

}
