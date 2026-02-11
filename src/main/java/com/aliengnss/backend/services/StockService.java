package com.aliengnss.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.infraestructura.repositorios.IInventarioMovimientoJpaRepository;
import com.aliengnss.backend.presentacion.consultas.SerialEnStockDto;
import com.aliengnss.backend.presentacion.consultas.StockUbicacionDto;

@Service
public class StockService {
  private final IInventarioMovimientoJpaRepository invRepo;

  public StockService(IInventarioMovimientoJpaRepository invRepo) {
    this.invRepo = invRepo;
  }

  public List<StockUbicacionDto> obtenerStockPorUbicacion() {
    return invRepo.stockPorUbicacion();
  }

  public List<StockUbicacionDto> obtenerStockPorUbicacion(Long idUbicacion) {
    return invRepo.stockPorUbicacion(idUbicacion);
  }

  public List<SerialEnStockDto> obtenerSerialesDisponiblesEnUbicacion(Long idUbicacion) {
    return invRepo.serialesDisponiblesEnUbicacion(idUbicacion);
  }
}