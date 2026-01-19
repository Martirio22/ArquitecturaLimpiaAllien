package com.aliengnss.backend.infraestructura.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;

public interface IUbicacionJpaRepository extends JpaRepository<UbicacionJpa, Long> {

}
