package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.InventarioMovimientoJpa;
import com.aliengnss.backend.presentacion.consultas.SerialEnStockDto;
import com.aliengnss.backend.presentacion.consultas.StockUbicacionDto;

public interface IInventarioMovimientoJpaRepository extends JpaRepository<InventarioMovimientoJpa, Long> {

	/*Traer todos los movimientos de (Venta, Compra o Traslado) del producto seleccionado por ID.*/
	@Query("SELECT im FROM InventarioMovimientoJpa im WHERE im.fkProducto.idProducto = :idProducto AND im.tipo = :tipo")
	List<InventarioMovimientoJpa> buscarPorProductoYTipo(
			@Param("idProducto") Long idProducto,
	        @Param("tipo") String tipo);
	
	/*Traer todos los movimientos de (Venta, Compra o Traslado) de la ubicación seleccionada entre dos fechas*/
	@Query("SELECT im FROM InventarioMovimientoJpa im WHERE im.fkUbicacion.idUbicacion = :idUbicacion AND im.tipo = :tipo AND im.fecha BETWEEN :fechaInicio AND :fechaFin")
	List<InventarioMovimientoJpa> buscarPorUbicacionTipoYFecha(
			 @Param("idUbicacion") Long idUbicacion,
	            @Param("tipo") String tipo,
	            @Param("fechaInicio") LocalDateTime fechaInicio,
	            @Param("fechaFin") LocalDateTime fechaFin
			);
	
	/*Historial de movimientos de un producto específico por su serial */
	@Query("SELECT im FROM InventarioMovimientoJpa im JOIN im.fkProductoSerial ps JOIN ps.fkProducto p WHERE ps.serial = :serial") 
	List<InventarioMovimientoJpa> buscarMovimientoPorSerial( 
			@Param("serial") String serial );
	

	@Query("SELECT COALESCE(SUM(im.cantidadEntrada), 0) - COALESCE(SUM(im.cantidadSalida), 0) " +
		       "FROM InventarioMovimientoJpa im " +
		       "WHERE im.fkProducto.idProducto = :idProducto " +
		       "AND im.fkUbicacion.idUbicacion = :idUbicacion " +
		       "AND im.esActivo = true") // <--- FILTRO CRUCIAL
		Integer obtenerStockPorProductoYUbicacion(
		    @Param("idProducto") Long idProducto, 
		    @Param("idUbicacion") Long idUbicacion);
	
	InventarioMovimientoJpa findTopByFkProductoSerial_IdProductoSerialAndEsActivoTrueOrderByFechaDescIdInventarioMovimientoDesc(Long idProductoSerial);
	
	@Query("""
			  select new com.aliengnss.backend.presentacion.consultas.StockUbicacionDto(
			    u.idUbicacion,
			    u.nombre,
			    p.idProducto,
			    p.nombre,
			    coalesce(sum(im.cantidadEntrada - im.cantidadSalida), 0)
			  )
			  from InventarioMovimientoJpa im
			  join im.fkUbicacion u
			  join im.fkProducto p
			  where coalesce(im.esActivo, true) = true
			  group by u.idUbicacion, u.nombre, p.idProducto, p.nombre
			  order by u.nombre, p.nombre
			""")
			List<StockUbicacionDto> stockPorUbicacion();


	@Query("""
			  select new com.aliengnss.backend.presentacion.consultas.StockUbicacionDto(
			    u.idUbicacion,
			    u.nombre,
			    p.idProducto,
			    p.nombre,
			    coalesce(sum(im.cantidadEntrada - im.cantidadSalida), 0)
			  )
			  from InventarioMovimientoJpa im
			  join im.fkUbicacion u
			  join im.fkProducto p
			  where coalesce(im.esActivo, true) = true
			    and u.idUbicacion = :idUbicacion
			  group by u.idUbicacion, u.nombre, p.idProducto, p.nombre
			  order by p.nombre
			""")
			List<StockUbicacionDto> stockPorUbicacion(@Param("idUbicacion") Long idUbicacion);

	@Query("""
			  select new com.aliengnss.backend.presentacion.consultas.SerialEnStockDto(
			    u.idUbicacion,
			    u.nombre,
			    p.idProducto,
			    p.nombre,
			    ps.idProductoSerial,
			    ps.serial
			  )
			  from InventarioMovimientoJpa im
			  join im.fkProductoSerial ps
			  join im.fkProducto p
			  join im.fkUbicacion u
			  where coalesce(im.esActivo, true) = true
			    and upper(ps.estado) = 'DISPONIBLE'
			    and im.fecha = (
			      select max(im2.fecha)
			      from InventarioMovimientoJpa im2
			      where im2.fkProductoSerial.idProductoSerial = ps.idProductoSerial
			        and coalesce(im2.esActivo, true) = true
			    )
			    and im.idInventarioMovimiento = (
			      select max(im3.idInventarioMovimiento)
			      from InventarioMovimientoJpa im3
			      where im3.fkProductoSerial.idProductoSerial = ps.idProductoSerial
			        and im3.fecha = im.fecha
			        and coalesce(im3.esActivo, true) = true
			    )
			    and u.idUbicacion = :idUbicacion
			  order by p.nombre, ps.serial
			""")
			List<SerialEnStockDto> serialesDisponiblesEnUbicacion(@Param("idUbicacion") Long idUbicacion);


}
