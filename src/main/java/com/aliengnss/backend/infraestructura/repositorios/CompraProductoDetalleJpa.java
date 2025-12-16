package com.aliengnss.backend.infraestructura.repositorios;

import com.aliengnss.backend.dominio.entidades.CompraProductoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraProductoDetalleJpa extends JpaRepository<CompraProductoDetalle,Long> {
}
