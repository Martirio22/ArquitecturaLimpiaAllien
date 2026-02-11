package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleVentaJpa;
import com.aliengnss.backend.presentacion.consultas.ComisionUsuarioDto;

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
	
	// ✅ todos (admin)
	  @Query("""
	    select new com.aliengnss.backend.presentacion.consultas.ComisionUsuarioDto(
	      u.idUsuario,
	      u.nombreUsuario,
	      concat(coalesce(u.primerNombre,''), ' ', coalesce(u.primerApellido,'')),
	      coalesce(sum(dv.subtotal), 0),
	      coalesce(sum(dv.subtotal * (dv.porcentajeComision / 100)), 0)
	    )
	    from DetalleVentaJpa dv
	    join dv.fkVenta v
	    join v.fkUsuario u
	    where coalesce(dv.esActivo, true) = true
	      and coalesce(v.esActivo, true) = true
	      and v.fechaVenta between :desde and :hasta
	    group by u.idUsuario, u.nombreUsuario, u.primerNombre, u.primerApellido
	    order by u.nombreUsuario
	  """)
	  List<ComisionUsuarioDto> comisionPorUsuarios(
	      @Param("desde") LocalDateTime desde,
	      @Param("hasta") LocalDateTime hasta
	  );

	  // ✅ uno (por id)
	  @Query("""
	    select new com.aliengnss.backend.presentacion.consultas.ComisionUsuarioDto(
	      u.idUsuario,
	      u.nombreUsuario,
	      concat(coalesce(u.primerNombre,''), ' ', coalesce(u.primerApellido,'')),
	      coalesce(sum(dv.subtotal), 0),
	      coalesce(sum(dv.subtotal * (dv.porcentajeComision / 100)), 0)
	    )
	    from DetalleVentaJpa dv
	    join dv.fkVenta v
	    join v.fkUsuario u
	    where coalesce(dv.esActivo, true) = true
	      and coalesce(v.esActivo, true) = true
	      and u.idUsuario = :idUsuario
	      and v.fechaVenta between :desde and :hasta
	    group by u.idUsuario, u.nombreUsuario, u.primerNombre, u.primerApellido
	  """)
	  Optional<ComisionUsuarioDto> comisionPorUsuario(
	      @Param("idUsuario") Long idUsuario,
	      @Param("desde") LocalDateTime desde,
	      @Param("hasta") LocalDateTime hasta
	  );
}
