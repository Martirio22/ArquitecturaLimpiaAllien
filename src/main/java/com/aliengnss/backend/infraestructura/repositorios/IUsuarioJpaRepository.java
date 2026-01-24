package com.aliengnss.backend.infraestructura.repositorios;


import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUsuarioJpaRepository extends JpaRepository<UsuarioJpa, Long> {
    
	@Query("SELECT u FROM UsuarioJpa u WHERE LOWER(u.primerNombre) LIKE LOWER(CONCAT('%', :nombre, '%')) OR LOWER(u.segundoNombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
		List<UsuarioJpa> buscarPorNombres(
		        @Param("nombre") String nombre);
	
	Optional<UsuarioJpa> findByCorreoElectronico(String correoElectronico);

	@Modifying
	@Transactional
	@Query("UPDATE UsuarioJpa u SET u.esActivo = NOT u.esActivo WHERE u.idUsuario = :id")
	void alternarEstado(@Param("id") Long idUsuario);
}
