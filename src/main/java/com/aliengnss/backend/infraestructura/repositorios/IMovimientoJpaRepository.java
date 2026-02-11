package com.aliengnss.backend.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;

public interface IMovimientoJpaRepository extends JpaRepository<MovimientoJpa, Long> {

	@Query("""
		    select m from MovimientoJpa m
		    left join fetch m.fkUsuario
		    left join fetch m.fkUbicacionOrigen
		    left join fetch m.fkUbicacionDestino
		    where m.idMovimiento = :id
		  """)
		  Optional<MovimientoJpa> findGuiaBase(@Param("id") Long id);
}
