package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoJpa;

public interface IMovimientoDetalleJpaRepository extends JpaRepository<MovimientoDetalleJpa, Long> {

   
    List<MovimientoDetalleJpa> findByFkMovimiento(MovimientoJpa fkMovimiento);

    List<MovimientoDetalleJpa> findByFkProducto(ProductoJpa fkProducto);

    Optional<MovimientoDetalleJpa> findByFkMovimientoAndFkProducto(MovimientoJpa fkMovimiento, ProductoJpa fkProducto);


    boolean existsByFkMovimientoAndFkProducto(MovimientoJpa fkMovimiento, ProductoJpa fkProducto);

    long countByFkMovimiento(MovimientoJpa fkMovimiento);

    long countByFkProducto(ProductoJpa fkProducto);

    List<MovimientoDetalleJpa> findByFkMovimientoAndCantidadGreaterThan(MovimientoJpa fkMovimiento, int cantidad);

    List<MovimientoDetalleJpa> findByFkMovimientoAndCantidadBetween(MovimientoJpa fkMovimiento, int min, int max);

    List<MovimientoDetalleJpa> findByFkMovimiento_IdMovimiento(Long idMovimiento);

    Optional<MovimientoDetalleJpa> findByFkMovimiento_IdMovimientoAndFkProducto_IdProducto(Long idMovimiento, Long idProducto);
}
