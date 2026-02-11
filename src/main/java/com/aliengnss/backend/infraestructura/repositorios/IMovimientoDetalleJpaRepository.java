package com.aliengnss.backend.infraestructura.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;

public interface IMovimientoDetalleJpaRepository extends JpaRepository<MovimientoDetalleJpa, Long> {
	@Query("""
		    select md from MovimientoDetalleJpa md
		    join fetch md.fkProducto p
		    where md.fkMovimiento.idMovimiento = :idMovimiento
		      and coalesce(md.esActivo, true) = true
		    order by p.nombre
		  """)
		  List<MovimientoDetalleJpa> findDetallesGuia(@Param("idMovimiento") Long idMovimiento);
}
