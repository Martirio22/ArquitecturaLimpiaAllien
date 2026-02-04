package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.CatalogoJpa;

public interface ICatalogoJpaRepository extends JpaRepository<CatalogoJpa, Long> {

}
