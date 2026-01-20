package com.aliengnss.backend.infraestructura.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ClienteJpa;

public interface IClienteJpaRepository extends JpaRepository<ClienteJpa, Long> {

}
