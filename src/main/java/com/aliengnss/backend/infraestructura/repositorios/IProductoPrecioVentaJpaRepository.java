package com.aliengnss.backend.infraestructura.repositorios;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.ProductoPrecioVentaJpa;

import jakarta.transaction.Transactional;

public interface IProductoPrecioVentaJpaRepository extends JpaRepository<ProductoPrecioVentaJpa, Long> {

    // Precio vigente (hasta = null)
    Optional<ProductoPrecioVentaJpa> findFirstByProductoIdProductoAndHastaIsNull(Long idProducto);

    // Cierra precio vigente (pone hasta = now)
    @Modifying
    @Transactional
    @Query("UPDATE ProductoPrecioVentaJpa p SET p.hasta = :hasta WHERE p.producto.idProducto = :idProducto AND p.hasta IS NULL")
    int cerrarPrecioActual(@Param("idProducto") Long idProducto, @Param("hasta") LocalDateTime hasta);
    
    List<ProductoPrecioVentaJpa> findByProductoIdProductoOrderByDesdeDesc(Long idProducto);


}
