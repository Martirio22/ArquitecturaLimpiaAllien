package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;

public interface IMovimientoDetalleJpaRepository extends JpaRepository<MovimientoDetalleJpa, Long> {

	// 1) Producto en rango
	@Query("""
			SELECT md
			FROM MovimientoDetalleJpa md
			JOIN md.fkMovimiento m
			JOIN md.fkProducto p
			WHERE p.idProducto = :idProducto
			  AND m.fechaMovimiento BETWEEN :fechaInicio AND :fechaFin
			ORDER BY m.fechaMovimiento DESC
			""")
	List<MovimientoDetalleJpa> movimientosDeProductoEnRango(@Param("idProducto") Long idProducto,
			@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

	// 2) Desde ubicacion origen en rango
	@Query("""
			SELECT md
			FROM MovimientoDetalleJpa md
			JOIN md.fkMovimiento m
			JOIN m.fkUbicacionOrigen uo
			WHERE uo.idUbicacion = :idUbicacionOrigen
			  AND m.fechaMovimiento BETWEEN :fechaInicio AND :fechaFin
			ORDER BY m.fechaMovimiento DESC
			""")
	List<MovimientoDetalleJpa> movimientosDesdeUbicacionEnRango(@Param("idUbicacionOrigen") Long idUbicacionOrigen,
			@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

	// 3) Hacia ubicacion destino en rango
	@Query("""
			SELECT md
			FROM MovimientoDetalleJpa md
			JOIN md.fkMovimiento m
			JOIN m.fkUbicacionDestino ud
			WHERE ud.idUbicacion = :idUbicacionDestino
			  AND m.fechaMovimiento BETWEEN :fechaInicio AND :fechaFin
			ORDER BY m.fechaMovimiento DESC
			""")
	List<MovimientoDetalleJpa> movimientosHaciaUbicacionEnRango(@Param("idUbicacionDestino") Long idUbicacionDestino,
			@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

	// 4) (opcional) Detalles por movimiento
	@Query("""
			SELECT md
			FROM MovimientoDetalleJpa md
			JOIN md.fkMovimiento m
			WHERE m.idMovimiento = :idMovimiento
			""")
	List<MovimientoDetalleJpa> detallesDeMovimiento(@Param("idMovimiento") Long idMovimiento);
}
