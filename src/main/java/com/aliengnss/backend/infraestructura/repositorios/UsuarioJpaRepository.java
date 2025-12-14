package com.aliengnss.backend.infraestructura.repositorios;


import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UsuarioJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioJpa, Long> {

    Optional<UsuarioJpa> findByNombreUsuario(String nombreUsuario);

    boolean existsByNombreUsuario(String nombreUsuario);

    List<UsuarioJpa> findByEsActivo(Character esActivo);

    Page<UsuarioJpa> findByEsActivo(Character esActivo, Pageable pageable);

    List<UsuarioJpa> findByPrimerNombre(String primerNombre);
}
