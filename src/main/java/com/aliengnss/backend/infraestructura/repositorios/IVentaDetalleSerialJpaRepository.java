package com.aliengnss.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaDetalleSerialJpa;

public interface IVentaDetalleSerialJpaRepository extends JpaRepository<VentaDetalleSerialJpa, Long> {

}
