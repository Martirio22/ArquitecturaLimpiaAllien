package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.MovimientoSeries;

public interface IMovimientoSeriesRepositorio {
	MovimientoSeries guardar(MovimientoSeries movimientoSeries);
    Optional<MovimientoSeries> buscarPorId(Long idMovimientoSeries);
    List<MovimientoSeries> listarTodos();
    void eliminar(Long idMovimientoSeries);
}
