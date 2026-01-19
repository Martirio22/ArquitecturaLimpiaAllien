package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Movimiento;

public interface IMovimientoRepositorio {

    Movimiento guardar(Movimiento movimiento);
    Optional<Movimiento> buscarPorId(Long idMovimiento);
    List<Movimiento> listarTodos();
    void eliminar(Long idMovimiento);

    }
