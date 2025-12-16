package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaJpa;

public interface VentaJpaRepository extends JpaRepository<VentaJpa, Long> {

}
