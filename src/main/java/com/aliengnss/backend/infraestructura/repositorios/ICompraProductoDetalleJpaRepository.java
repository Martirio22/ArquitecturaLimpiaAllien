package com.aliengnss.backend.infraestructura.repositorios;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.CompraProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;

public interface ICompraProductoDetalleJpaRepository extends JpaRepository<CompraProductoDetalleJpa, Long> {

    List<CompraProductoDetalleJpa> findByFkCompraProducto(CompraProductoJpa fkCompraProducto);

    List<CompraProductoDetalleJpa> findByFkProducto(ProductoJpa fkProducto);

    List<CompraProductoDetalleJpa> findByFkUbicacion(UbicacionJpa fkUbicacion);


    Optional<CompraProductoDetalleJpa> findByFkCompraProductoAndFkProducto(
            CompraProductoJpa fkCompraProducto, ProductoJpa fkProducto
    );

    List<CompraProductoDetalleJpa> findByFkCompraProductoAndFkUbicacion(
            CompraProductoJpa fkCompraProducto, UbicacionJpa fkUbicacion
    );

    Optional<CompraProductoDetalleJpa> findByFkCompraProductoAndFkProductoAndFkUbicacion(
            CompraProductoJpa fkCompraProducto, ProductoJpa fkProducto, UbicacionJpa fkUbicacion
    );

    List<CompraProductoDetalleJpa> findByFkCompraProductoAndCantidadGreaterThan(
            CompraProductoJpa fkCompraProducto, int cantidad
    );

    List<CompraProductoDetalleJpa> findByFkCompraProductoAndCostoUnitarioBetween(
            CompraProductoJpa fkCompraProducto, BigDecimal min, BigDecimal max
    );

    List<CompraProductoDetalleJpa> findByFkCompraProducto_IdCompraProducto(Long idCompraProducto);

    Optional<CompraProductoDetalleJpa> findByFkCompraProducto_IdCompraProductoAndFkProducto_IdProducto(
            Long idCompraProducto, Long idProducto
    );
}
