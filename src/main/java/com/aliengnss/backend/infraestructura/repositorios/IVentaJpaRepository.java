package com.aliengnss.backend.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaJpa;

public interface IVentaJpaRepository extends JpaRepository<VentaJpa, Long> {

	// Busca la última venta registrada para obtener su número
    Optional<VentaJpa> findFirstByOrderByIdVentaDesc();
}
