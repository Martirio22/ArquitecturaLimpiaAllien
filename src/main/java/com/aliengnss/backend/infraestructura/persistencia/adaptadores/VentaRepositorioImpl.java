package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Venta;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IVentaJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IVentaJpaRepository;


public class VentaRepositorioImpl implements IVentaRepositorio {

    private final IVentaJpaRepository ventaJpaRepository;
    private final IVentaJpaMapper mapper;

    public VentaRepositorioImpl(IVentaJpaRepository ventaJpaRepository, IVentaJpaMapper mapper) {
        this.ventaJpaRepository = ventaJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Venta guardar(Venta venta) {
        System.out.println(">>> TRACE VentaRepositorioImpl.guardar idVenta=" + venta.getIdVenta()
            + " subtotal=" + venta.getSubtotal()
            + " ivaValor=" + venta.getIvaValor()
            + " total=" + venta.getTotal());

        // imprime quién llamó
        Thread.dumpStack();

        return mapper.toDomain(ventaJpaRepository.save(mapper.toEntity(venta)));
    }

    @Override
    public Optional<Venta> buscarPorId(Long idVenta) {
        return ventaJpaRepository.findById(idVenta).map(mapper::toDomain);
    }

    @Override
    public List<Venta> listarTodos() {
        return ventaJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long idVenta) {
        ventaJpaRepository.deleteById(idVenta);
    }

    @Override
    public boolean existeNumeroFactura(String numeroFactura) {
        return ventaJpaRepository.existsByNumeroFactura(numeroFactura);
    }
}
