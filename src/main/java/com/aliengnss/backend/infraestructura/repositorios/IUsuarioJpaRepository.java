package com.aliengnss.backend.infraestructura.repositorios;


import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUsuarioJpaRepository extends JpaRepository<UsuarioJpa, Long> {
    
	@Query("SELECT u FROM UsuarioJpa u WHERE LOWER(u.primerNombre) LIKE LOWER(CONCAT('%', :nombre, '%')) OR LOWER(u.segundoNombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
		List<UsuarioJpa> buscarPorNombres(
		        @Param("nombre") String nombre);

}
