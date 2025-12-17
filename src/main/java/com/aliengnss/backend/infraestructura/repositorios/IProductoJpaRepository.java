package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;

public interface IProductoJpaRepository extends JpaRepository<ProductoJpa, Long> {

}
