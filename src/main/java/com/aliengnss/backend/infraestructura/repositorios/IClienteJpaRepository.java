package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ClienteJpa;

public interface IClienteJpaRepository extends JpaRepository<ClienteJpa, Long> {

	Optional<ClienteJpa> findByDocumento(String documento);

	Optional<ClienteJpa> findByEmail(String email);

	Optional<ClienteJpa> findByTelefono(String telefono);

	List<ClienteJpa> findByPrimerNombreContainingIgnoreCase(String primerNombre);

	List<ClienteJpa> findByPrimerApellidoContainingIgnoreCase(String primerApellido);

	List<ClienteJpa> findByPrimerNombreIgnoreCaseAndPrimerApellidoIgnoreCase(String primerNombre, String primerApellido);

	List<ClienteJpa> findByDocumentoAndPrimerApellidoIgnoreCase(String documento, String primerApellido);

	List<ClienteJpa> findByTelefonoAndDocumento(String telefono, String documento);

	List<ClienteJpa> findByEmailContainingIgnoreCaseAndDocumento(String email, String documento);

	List<ClienteJpa> findByPrimerNombreContainingIgnoreCaseOrPrimerApellidoContainingIgnoreCaseOrDocumentoContainingIgnoreCase(
			String primerNombre, String primerApellido, String documento
	);
}
