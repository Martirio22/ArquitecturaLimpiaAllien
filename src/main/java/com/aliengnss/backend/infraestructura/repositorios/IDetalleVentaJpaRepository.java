package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleVentaJpa;

public interface IDetalleVentaJpaRepository extends JpaRepository<DetalleVentaJpa, Long>{

}
