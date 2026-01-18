package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoSerialJpa;

public interface IProductoSerialJpaRepository extends JpaRepository<ProductoSerialJpa, Long> {

}
