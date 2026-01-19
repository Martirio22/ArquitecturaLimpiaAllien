package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoJpa;

public interface ICompraProductoJpaRepository extends JpaRepository<CompraProductoJpa, Long> {

    
}
