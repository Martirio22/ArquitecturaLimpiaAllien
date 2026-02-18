package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.VentaDetalleSerial;
import com.aliengnss.backend.dominio.repositorios.IVentaDetalleSerialRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.VentaDetalleSerialJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IVentaDetalleSerialJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IVentaDetalleSerialJpaRepository;

public class VentaDetalleSerialRepositorioImpl implements IVentaDetalleSerialRepositorio {

	private final IVentaDetalleSerialJpaRepository cpJpaRepository;
	private final IVentaDetalleSerialJpaMapper entityMapper;
	
	public VentaDetalleSerialRepositorioImpl(IVentaDetalleSerialJpaRepository cpJpaRepository,
			IVentaDetalleSerialJpaMapper entityMapper) {
		super();
		this.cpJpaRepository = cpJpaRepository;
		this.entityMapper = entityMapper;
	}


	@Override
	public VentaDetalleSerial guardar(VentaDetalleSerial ventaDetalleSerial) {
		VentaDetalleSerialJpa entity = entityMapper.toEntity(ventaDetalleSerial);
		VentaDetalleSerialJpa guardado = cpJpaRepository.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<VentaDetalleSerial> buscarPorId(Long idVentaDetalleSerial) {
		return cpJpaRepository.findById(idVentaDetalleSerial).map(entityMapper::toDomain);
	}

	@Override
	public List<VentaDetalleSerial> listarTodos() {
		return cpJpaRepository.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(Long idVentaDetalleSerial) {
		cpJpaRepository.deleteById(idVentaDetalleSerial);
		
	}
}
