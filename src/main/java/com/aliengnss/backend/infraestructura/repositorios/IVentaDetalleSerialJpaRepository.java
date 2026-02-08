package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaDetalleSerialJpa;

public interface IVentaDetalleSerialJpaRepository extends JpaRepository<VentaDetalleSerialJpa, Long> {

	/* Saber qué productos con serial compró un cliente en un rango de fechas. */
	@Query("SELECT vds FROM VentaDetalleSerialJpa vds JOIN vds.fkDetalleVenta dv JOIN dv.fkVenta v JOIN v.fkCliente c JOIN vds.fkProductoSerial ps JOIN ps.fkProducto p WHERE c.idCliente = :idCliente AND v.fechaVenta BETWEEN :fechaInicio AND :fechaFin")
	List<VentaDetalleSerialJpa> ventasPorClienteConSerial(@Param("idCliente") Long idCliente,
			@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

	@Query("""
			  select vds from VentaDetalleSerialJpa vds
			  join fetch vds.fkProductoSerial ps
			  where vds.fkDetalleVenta.idDetalleVenta in :ids
			""")
	List<VentaDetalleSerialJpa> findByDetalleIds(@Param("ids") List<Long> ids);
}
