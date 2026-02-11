package com.aliengnss.backend.presentacion.controladores;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aliengnss.backend.presentacion.consultas.ComisionUsuarioDto;
import com.aliengnss.backend.services.ComisionReportService;

@RestController
@RequestMapping("/api/reportes")
public class ReportesController {

  private final ComisionReportService comisionService;

  public ReportesController(ComisionReportService comisionService) {
    this.comisionService = comisionService;
  }

  // ✅ Solo 1 usuario
  @GetMapping("/comisiones/usuarios/{idUsuario}")
  public ComisionUsuarioDto comisionUsuario(
      @PathVariable Long idUsuario,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta
  ) {
    return comisionService.comisionDeUsuario(idUsuario, desde, hasta);
  }

  // ✅ Todos (admin)
  @GetMapping("/comisiones/usuarios")
  public List<ComisionUsuarioDto> comisionesUsuarios(
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta
  ) {
    return comisionService.comisionPorUsuario(desde, hasta);
  }
}