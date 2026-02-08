package com.aliengnss.backend.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaJpa;

public interface IVentaJpaRepository extends JpaRepository<VentaJpa, Long> {

	// Busca la última venta registrada para obtener su número
	Optional<VentaJpa> findFirstByOrderByIdVentaDesc();

	boolean existsByNumeroFactura(String numeroFactura);

	@Query("""
			  select v from VentaJpa v
			  left join fetch v.fkCliente
			  left join fetch v.fkUsuario
			  where v.idVenta = :id
			""")
	Optional<VentaJpa> findFacturaBase(@Param("id") Long id);
}
