package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ClienteJpa;

public interface IClienteJpaRepository extends JpaRepository<ClienteJpa, Long>{
	
	List<ClienteJpa> findByPrimerNombre(String primerNombre);
	List<ClienteJpa> findByDocumento(String documento);

}
