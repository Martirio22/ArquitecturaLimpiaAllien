package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;

public interface IMovimientoUseCase {

    Movimiento crear(MovimientoRequestDto dto);

    Movimiento buscarPorId(Long idMovimiento);
    Movimiento actualizar(Movimiento movimiento);
    List<Movimiento> listarTodos();

    void eliminar(Long idMovimiento);

}
