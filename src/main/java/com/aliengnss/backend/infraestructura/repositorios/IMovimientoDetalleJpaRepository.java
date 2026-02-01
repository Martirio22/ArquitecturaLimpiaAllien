package com.aliengnss.backend.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;

@Repository
public interface IMovimientoDetalleJpaRepository extends JpaRepository<MovimientoDetalleJpa, Long> {

    /**
     * Busca todos los detalles asociados a un movimiento específico
     * Usa el nombre del campo 'fkMovimiento' en MovimientoDetalleJpa
     */
    @Query("SELECT md FROM MovimientoDetalleJpa md WHERE md.fkMovimiento.idMovimiento = :idMovimiento")
    List<MovimientoDetalleJpa> findByMovimientoIdMovimiento(@Param("idMovimiento") Long idMovimiento);
    
    /**
     * Alternativa usando convención de nombres de Spring Data
     * (puedes usar esta en lugar de la @Query si prefieres)
     */
    // List<MovimientoDetalleJpa> findByFkMovimiento_IdMovimiento(Long idMovimiento);
    
    /**
     * Elimina todos los detalles de un movimiento (útil para actualizar)
     */
    void deleteByFkMovimiento_IdMovimiento(Long idMovimiento);
}