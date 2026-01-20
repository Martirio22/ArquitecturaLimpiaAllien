package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;

public interface ICompraProductoDetalleJpaRepository extends JpaRepository<CompraProductoDetalleJpa, Long> {

	/*Saber qué productos registró un usuario en compras*/
	@Query("SELECT cpd FROM CompraProductoDetalleJpa cpd JOIN cpd.fkCompraProducto cp JOIN cp.fkUsuario u JOIN cpd.fkProducto p WHERE u.idUsuario = :idUsuario AND cpd.fkProducto.idProducto = :idProducto")
	List<CompraProductoDetalleJpa> buscarPorComprasUsuarioYProducto(
		    @Param("idUsuario") Long idUsuario,
		    @Param("idProducto") Long idProducto
		);

}
