package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;

public interface IMovimientoJpaRepository extends JpaRepository<MovimientoJpa, Long> {


}
