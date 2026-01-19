package com.aliengnss.backend.infraestructura.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;

public interface IMovimientoDetalleJpaRepository extends JpaRepository<MovimientoDetalleJpa, Long> {

}
