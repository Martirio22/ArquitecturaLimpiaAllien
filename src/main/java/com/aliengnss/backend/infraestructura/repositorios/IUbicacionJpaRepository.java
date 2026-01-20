package com.aliengnss.backend.infraestructura.repositorios;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aliengnss.backend.infraestructura.persistencia.jpa.UbicacionJpa;

public interface IUbicacionJpaRepository extends JpaRepository<UbicacionJpa, Long> {

	@Query("SELECT u FROM UbicacionJpa u WHERE u.tipo = :tipo")
    List<UbicacionJpa> buscarPorTipo(@Param("tipo") String tipo);

    @Query("SELECT u FROM UbicacionJpa u " +
           "WHERE LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<UbicacionJpa> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT u FROM UbicacionJpa u " +
           "WHERE u.tipo = :tipo " +
           "AND LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<UbicacionJpa> buscarPorTipoYNombre(@Param("tipo") String tipo,
                                            @Param("nombre") String nombre);
}
