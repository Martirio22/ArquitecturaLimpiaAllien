package com.aliengnss.backend.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.aliengnss.backend.infraestructura.persistencia.jpa.DetalleVentaJpa;
import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaDetalleSerialJpa;
import com.aliengnss.backend.infraestructura.repositorios.IDetalleVentaJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IVentaDetalleSerialJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IVentaJpaRepository;
import com.aliengnss.backend.presentacion.dto.res.FacturaVentaResponseDto;

@Service
public class FacturaVentaService {

  private final IVentaJpaRepository ventaRepo;
  private final IDetalleVentaJpaRepository detalleRepo;

  // opcional: si no existe repo o no quieres seriales, puedes quitarlo
  private final IVentaDetalleSerialJpaRepository serialRepo;

  public FacturaVentaService(IVentaJpaRepository ventaRepo,
                             IDetalleVentaJpaRepository detalleRepo,
                             IVentaDetalleSerialJpaRepository serialRepo) {
    this.ventaRepo = ventaRepo;
    this.detalleRepo = detalleRepo;
    this.serialRepo = serialRepo;
  }

  public FacturaVentaResponseDto obtenerFactura(Long idVenta) {

    var venta = ventaRepo.findFacturaBase(idVenta)
      .orElseThrow(() -> new RuntimeException("Venta no encontrada: " + idVenta));

    var detalles = detalleRepo.findDetallesFactura(idVenta);

    // -------------------------
    // Seriales (opcional)
    // -------------------------
    Map<Long, List<String>> serialesPorDetalleTmp = Map.of();

    if (serialRepo != null && !detalles.isEmpty()) {
      var ids = detalles.stream().map(DetalleVentaJpa::getIdDetalleVenta).toList();

      List<VentaDetalleSerialJpa> seriales = serialRepo.findByDetalleIds(ids);

      serialesPorDetalleTmp = seriales.stream().collect(Collectors.groupingBy(
        s -> s.getFkDetalleVenta().getIdDetalleVenta(),
        Collectors.mapping(s -> s.getFkProductoSerial().getSerial(), Collectors.toList())
      ));
    }

    final Map<Long, List<String>> serialesPorDetalle = serialesPorDetalleTmp;

    // -------------------------
    // Armado DTO
    // -------------------------
    FacturaVentaResponseDto dto = new FacturaVentaResponseDto();
    dto.setIdVenta(venta.getIdVenta());
    dto.setNumeroFactura(venta.getNumeroFactura());
    dto.setFechaVenta(venta.getFechaVenta());
    dto.setTotal(venta.getTotal());
    dto.setObservaciones(venta.getObservaciones());

    // cliente
    if (venta.getFkCliente() != null) {
      var c = venta.getFkCliente();
      var cdto = new FacturaVentaResponseDto.ClienteFacturaDto();
      cdto.setIdCliente(c.getIdCliente());
      cdto.setPrimerNombre(c.getPrimerNombre());
      cdto.setSegundoNombre(c.getSegundoNombre());
      cdto.setPrimerApellido(c.getPrimerApellido());
      cdto.setSegundoApellido(c.getSegundoApellido());
      cdto.setDocumento(c.getDocumento());
      cdto.setTelefono(c.getTelefono());
      cdto.setEmail(c.getEmail());
      cdto.setDireccion(c.getDireccion());
      dto.setCliente(cdto);
    }

    // usuario
    if (venta.getFkUsuario() != null) {
      var u = venta.getFkUsuario();
      var udto = new FacturaVentaResponseDto.UsuarioFacturaDto();
      udto.setIdUsuario(u.getIdUsuario());
      udto.setNombreUsuario(u.getNombreUsuario());
      udto.setPrimerNombre(u.getPrimerNombre());
      udto.setPrimerApellido(u.getPrimerApellido());
      dto.setUsuario(udto);
    }

    // detalles
    dto.setDetalles(detalles.stream().map(dv -> {
      var ddto = new FacturaVentaResponseDto.DetalleFacturaDto();
      ddto.setIdDetalleVenta(dv.getIdDetalleVenta());
      ddto.setCantidad(dv.getCantidad());
      ddto.setPrecioUnitario(dv.getPrecioUnitario());
      ddto.setSubtotal(dv.getSubtotal());

      if (dv.getFkProducto() != null) {
        var p = dv.getFkProducto();
        var pdto = new FacturaVentaResponseDto.ProductoDto();
        pdto.setIdProducto(p.getIdProducto());
        pdto.setNombre(p.getNombre());
        pdto.setMarca(p.getMarca());
        pdto.setTipo(p.getTipo());
        pdto.setEsConSerial(p.getEsConSerial());
        ddto.setProducto(pdto);
      }

      if (dv.getFkUbicacion() != null) {
        var u = dv.getFkUbicacion();
        var udto = new FacturaVentaResponseDto.UbicacionDto();
        udto.setIdUbicacion(u.getIdUbicacion());
        udto.setNombre(u.getNombre());
        ddto.setUbicacion(udto);
      }

      ddto.setSeriales(serialesPorDetalle.getOrDefault(dv.getIdDetalleVenta(), List.of()));
      return ddto;
    }).toList());

    return dto;
  }
}