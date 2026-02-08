package com.aliengnss.backend.infraestructura.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ClienteJpa;

public interface IClienteJpaRepository extends JpaRepository<ClienteJpa, Long> {
	Optional<ClienteJpa> findByDocumento(String documento);
	Optional<ClienteJpa> findByEmail(String email);
	Optional<ClienteJpa> findByTelefono(String telefono);


}
