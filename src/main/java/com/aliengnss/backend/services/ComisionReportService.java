package com.aliengnss.backend.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.infraestructura.repositorios.IDetalleVentaJpaRepository;
import com.aliengnss.backend.presentacion.consultas.ComisionUsuarioDto;

@Service
public class ComisionReportService {

  private final IDetalleVentaJpaRepository detalleRepo;

  public ComisionReportService(IDetalleVentaJpaRepository detalleRepo) {
    this.detalleRepo = detalleRepo;
  }

  public List<ComisionUsuarioDto> comisionPorUsuario(LocalDateTime desde, LocalDateTime hasta) {
    return detalleRepo.comisionPorUsuarios(desde, hasta);
  }

  public ComisionUsuarioDto comisionDeUsuario(Long idUsuario, LocalDateTime desde, LocalDateTime hasta) {
    return detalleRepo.comisionPorUsuario(idUsuario, desde, hasta)
      .orElse(new ComisionUsuarioDto(idUsuario, "(sin ventas)", "", 
              java.math.BigDecimal.ZERO, java.math.BigDecimal.ZERO));
  }
}