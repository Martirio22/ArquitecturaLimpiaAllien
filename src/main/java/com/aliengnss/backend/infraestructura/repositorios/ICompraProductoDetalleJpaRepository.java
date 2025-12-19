package com.aliengnss.backend.infraestructura.repositorios;

import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraProductoDetalleJpaRepository extends JpaRepository<CompraProductoDetalleJpa,Long> {
}
