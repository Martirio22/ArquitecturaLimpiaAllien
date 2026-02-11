package com.aliengnss.backend.presentacion.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.presentacion.consultas.SerialEnStockDto;
import com.aliengnss.backend.presentacion.consultas.StockUbicacionDto;
import com.aliengnss.backend.services.StockService;

@RestController
@RequestMapping("/api/inventario")
public class InventarioReportController {

  private final StockService stockService;

  public InventarioReportController(StockService stockService) {
    this.stockService = stockService;
  }

  @GetMapping("/stock")
  public List<StockUbicacionDto> stockPorUbicacion() {
    return stockService.obtenerStockPorUbicacion();
  }

  @GetMapping("/ubicaciones/{idUbicacion}/stock")
  public List<StockUbicacionDto> stockPorUnaUbicacion(@PathVariable Long idUbicacion) {
    return stockService.obtenerStockPorUbicacion(idUbicacion);
  }

  // ✅ NUEVO: seriales disponibles por ubicación
  @GetMapping("/ubicaciones/{idUbicacion}/seriales-disponibles")
  public List<SerialEnStockDto> serialesDisponibles(@PathVariable Long idUbicacion) {
    return stockService.obtenerSerialesDisponiblesEnUbicacion(idUbicacion);
  }
}