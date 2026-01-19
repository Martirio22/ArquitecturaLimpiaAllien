package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;

public interface ICompraProductoDetalleJpaRepository extends JpaRepository<CompraProductoDetalleJpa, Long> {

    
}
