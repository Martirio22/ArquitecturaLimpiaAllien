package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleSerialJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoSerialJpa;

public interface IMovimientoSeriesJpaRepository extends JpaRepository<MovimientoDetalleSerialJpa, Long> {

    List<MovimientoDetalleSerialJpa> findByFkMovimientoDetalle(MovimientoDetalleJpa fkMovimientoDetalle);

    List<MovimientoDetalleSerialJpa> findByFkProductoSerial(ProductoSerialJpa fkProductoSerial);

    Optional<MovimientoDetalleSerialJpa> findByFkMovimientoDetalleAndFkProductoSerial(
            MovimientoDetalleJpa fkMovimientoDetalle,
            ProductoSerialJpa fkProductoSerial
    );

    boolean existsByFkMovimientoDetalleAndFkProductoSerial(
            MovimientoDetalleJpa fkMovimientoDetalle,
            ProductoSerialJpa fkProductoSerial
    );

    long deleteByFkMovimientoDetalle(MovimientoDetalleJpa fkMovimientoDetalle);

    long countByFkMovimientoDetalle(MovimientoDetalleJpa fkMovimientoDetalle);

    long countByFkProductoSerial(ProductoSerialJpa fkProductoSerial);

    List<MovimientoDetalleSerialJpa> findByFkMovimientoDetalle_IdMovimientoDetalle(Long idMovimientoDetalle);

    List<MovimientoDetalleSerialJpa> findByFkProductoSerial_IdProductoSerial(Long idProductoSerial);

    Optional<MovimientoDetalleSerialJpa> findByFkMovimientoDetalle_IdMovimientoDetalleAndFkProductoSerial_IdProductoSerial(
            Long idMovimientoDetalle,
            Long idProductoSerial
    );
}
