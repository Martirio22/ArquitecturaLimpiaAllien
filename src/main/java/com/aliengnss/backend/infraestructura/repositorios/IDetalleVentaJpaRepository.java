package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleVentaJpa;

public interface IDetalleVentaJpaRepository extends JpaRepository<DetalleVentaJpa, Long> {

	/* cuánto se vendió de un producto en cada tienda. */
	@Query(" SELECT dv FROM DetalleVentaJpa dv JOIN dv.fkVenta v JOIN dv.fkProducto p JOIN dv.fkUbicacion u WHERE p.idProducto = :idProducto AND u.idUbicacion = :idUbicacion AND v.fechaVenta BETWEEN :fechaInicio AND :fechaFin")
	List<DetalleVentaJpa> ventasPorProductoUbicacionYFecha(@Param("idProducto") Long idProducto,
			@Param("idUbicacion") Long idUbicacion, @Param("fechaInicio") LocalDateTime fechaInicio,
			@Param("fechaFin") LocalDateTime fechaFin);

	@Query("""
			  select dv from DetalleVentaJpa dv
			  join fetch dv.fkProducto p
			  left join fetch dv.fkUbicacion u
			  where dv.fkVenta.idVenta = :idVenta
			""")
	List<DetalleVentaJpa> findDetallesFactura(@Param("idVenta") Long idVenta);
}
