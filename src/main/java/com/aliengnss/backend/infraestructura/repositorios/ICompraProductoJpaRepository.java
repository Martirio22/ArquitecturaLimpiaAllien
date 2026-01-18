package com.aliengnss.backend.infraestructura.repositorios;

import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraProductoJpaRepository extends JpaRepository<CompraProductoJpa, Long> {
}
