package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleCatalogoJpa;

public interface IDetalleCatalogoJpaRepository extends JpaRepository<DetalleCatalogoJpa, Long> {

	@Query("""
	        select d
	        from DetalleCatalogoJpa d
	        where lower(d.catalogo.nombreCatalogo) = lower(:nombre)
	          and d.esActivo = true
	          and d.catalogo.esActivo = true
	        order by d.orden asc, d.descripcion asc
	    """)
	    List<DetalleCatalogoJpa> listarDetallesPorNombreCatalogo(@Param("nombre") String nombreCatalogo);
}
