package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoPrecioVentaJpa;

public interface IProductoJpaRepository extends JpaRepository<ProductoJpa, Long> {

	@Query("SELECT p FROM ProductoJpa p WHERE p.esConSerial = :esConSerial")
	List<ProductoJpa> buscarPorSerial(@Param("esConSerial") boolean esConSerial);

	Optional<ProductoJpa> findByNombreIgnoreCaseAndMarcaIgnoreCaseAndTipoIgnoreCase(String nombre, String marca,
			String tipo);

	@Query("""
			    SELECT p.idProducto as idProducto,
			           p.nombre as nombre,
			           p.marca as marca,
			           p.tipo as tipo,
			           p.descripcion as descripcion,
			           p.esConSerial as esConSerial,
			           p.porcentajeComision as porcentajeComision,
			           p.fechaCreacion as fechaCreacion,
			           p.esActivo as esActivo
			    FROM ProductoJpa p
			""")
	List<ProductoLiteProjection> listarSinFoto();
}
