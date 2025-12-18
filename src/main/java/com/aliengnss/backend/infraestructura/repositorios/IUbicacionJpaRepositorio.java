package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;

public interface IUbicacionJpaRepositorio extends JpaRepository<UbicacionJpa, Long> {

	List<UbicacionJpa> findByTipo(String tipo);

	List<UbicacionJpa> findByNombreContainingIgnoreCase(String nombre);
}
