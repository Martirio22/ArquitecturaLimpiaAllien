package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;

public interface IProductoJpaRepository extends JpaRepository<ProductoJpa, Long> {

	@Query("SELECT p FROM ProductoJpa p WHERE p.esConSerial = :esConSerial")
		List<ProductoJpa> buscarPorSerial(
		        @Param("esConSerial") boolean esConSerial
		);

}
