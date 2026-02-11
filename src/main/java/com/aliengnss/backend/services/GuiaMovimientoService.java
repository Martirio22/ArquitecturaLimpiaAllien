package com.aliengnss.backend.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.infraestructura.persistencia.jpa.MovimientoDetalleJpa;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoDetalleJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoSeriesJpaRepository;
import com.aliengnss.backend.presentacion.dto.res.GuiaMovimientoResponseDto;

@Service
public class GuiaMovimientoService {

  private final IMovimientoJpaRepository movRepo;
  private final IMovimientoDetalleJpaRepository detalleRepo;
  private final IMovimientoSeriesJpaRepository seriesRepo; // ✅ TU repo

  public GuiaMovimientoService(
      IMovimientoJpaRepository movRepo,
      IMovimientoDetalleJpaRepository detalleRepo,
      IMovimientoSeriesJpaRepository seriesRepo
  ) {
    this.movRepo = movRepo;
    this.detalleRepo = detalleRepo;
    this.seriesRepo = seriesRepo;
  }

  public GuiaMovimientoResponseDto obtenerGuia(Long idMovimiento) {

    var mov = movRepo.findGuiaBase(idMovimiento)
        .orElseThrow(() -> new RuntimeException("Movimiento no encontrado: " + idMovimiento));

    var detalles = detalleRepo.findDetallesGuia(idMovimiento);

    Map<Long, List<String>> serialesPorDetalle = Map.of();

    if (!detalles.isEmpty()) {
      var ids = detalles.stream()
          .map(MovimientoDetalleJpa::getIdMovimientoDetalle)
          .toList();

      var seriales = seriesRepo.findByDetalleIds(ids);

      serialesPorDetalle = seriales.stream().collect(Collectors.groupingBy(
          s -> s.getFkMovimientoDetalle().getIdMovimientoDetalle(),
          Collectors.mapping(s -> s.getFkProductoSerial().getSerial(), Collectors.toList())
      ));
    }

    // ---- DTO cabecera (igual que antes) ----
    var dto = new GuiaMovimientoResponseDto();
    dto.setIdMovimiento(mov.getIdMovimiento());
    dto.setTipo(mov.getTipo());
    dto.setFechaMovimiento(mov.getFechaMovimiento());
    dto.setObservaciones(mov.getObservaciones());

    if (mov.getFkUsuario() != null) {
      var u = mov.getFkUsuario();
      var ud = new GuiaMovimientoResponseDto.UsuarioDto();
      ud.setIdUsuario(u.getIdUsuario());
      ud.setNombreUsuario(u.getNombreUsuario());
      ud.setPrimerNombre(u.getPrimerNombre());
      ud.setPrimerApellido(u.getPrimerApellido());
      dto.setUsuario(ud);
    }

    if (mov.getFkUbicacionOrigen() != null) {
      var o = mov.getFkUbicacionOrigen();
      var od = new GuiaMovimientoResponseDto.UbicacionDto();
      od.setIdUbicacion(o.getIdUbicacion());
      od.setNombre(o.getNombre());
      dto.setUbicacionOrigen(od);
    }

    if (mov.getFkUbicacionDestino() != null) {
      var d = mov.getFkUbicacionDestino();
      var dd = new GuiaMovimientoResponseDto.UbicacionDto();
      dd.setIdUbicacion(d.getIdUbicacion());
      dd.setNombre(d.getNombre());
      dto.setUbicacionDestino(dd);
    }

    // ---- DTO detalles ----
    final Map<Long, List<String>> serialesMap = serialesPorDetalle;

    dto.setDetalles(detalles.stream().map(md -> {
      var p = md.getFkProducto();

      var dd = new GuiaMovimientoResponseDto.DetalleDto();
      dd.setIdMovimientoDetalle(md.getIdMovimientoDetalle());
      dd.setIdProducto(p.getIdProducto());
      dd.setProducto(p.getNombre());
      dd.setMarca(p.getMarca());
      dd.setTipo(p.getTipo());
      dd.setEsConSerial(p.getEsConSerial());

      var seriales = serialesMap.getOrDefault(md.getIdMovimientoDetalle(), List.of());
      dd.setSeriales(seriales);

      // si es serial, cantidad mejor = #seriales
      if (Boolean.TRUE.equals(p.getEsConSerial())) dd.setCantidad(seriales.size());
      else dd.setCantidad(md.getCantidad());

      return dd;
    }).toList());

    return dto;
  }
}