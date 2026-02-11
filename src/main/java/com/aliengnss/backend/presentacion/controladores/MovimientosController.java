package com.aliengnss.backend.presentacion.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.presentacion.dto.res.GuiaMovimientoResponseDto;
import com.aliengnss.backend.services.GuiaMovimientoService;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientosController {
	private final GuiaMovimientoService guiaService;

	  public MovimientosController(GuiaMovimientoService guiaService) {
	    this.guiaService = guiaService;
	  }

	  @GetMapping("/{idMovimiento}/guia")
	  public GuiaMovimientoResponseDto guia(@PathVariable Long idMovimiento) {
	    return guiaService.obtenerGuia(idMovimiento);
	  }
}
