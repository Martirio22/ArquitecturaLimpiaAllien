package com.aliengnss.backend.infraestructura.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;


public interface IUbicacionJpaRepository extends JpaRepository<UbicacionJpa, Long> {
	 
	@Query("""
			SELECT u 
			FROM UbicacionJpa u 
			WHERE LOWER(u.nombre) = LOWER(:nombre)
			""")
			Optional<UbicacionJpa> buscarPorNombreExacto(@Param("nombre") String nombre);



}
	