package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.InventarioMovimientoJpa;

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

}
