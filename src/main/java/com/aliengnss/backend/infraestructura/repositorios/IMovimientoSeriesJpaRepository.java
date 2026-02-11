package com.aliengnss.backend.infraestructura.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleSerialJpa;

public interface IMovimientoSeriesJpaRepository extends JpaRepository<MovimientoDetalleSerialJpa, Long> {
	@Query("""
		    select ms from MovimientoDetalleSerialJpa ms
		    join fetch ms.fkMovimientoDetalle md
		    join fetch ms.fkProductoSerial ps
		    where md.idMovimientoDetalle in :ids
		      and coalesce(ms.esActivo, true) = true
		  """)
		  List<MovimientoDetalleSerialJpa> findByDetalleIds(@Param("ids") List<Long> ids);
    
}
