package com.aliengnss.backend.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.MovimientoDetalleUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.MovimientoUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.UbicacionUseCaseImpl;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.MovimientoDetalleRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.MovimientoRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.UbicacionRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IUbicacionJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoDetalleJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IUbicacionJpaRepositorio;


public class ConfiguracionGeneral {


	@Bean
	IUbicacionRepositorio UbicacionRepositorio(IUbicacionJpaRepositorio ubiJpaRepositorio, IUbicacionJpaMapper ubiJpaMapper) {
		return new UbicacionRepositorioImpl(ubiJpaRepositorio,ubiJpaMapper);
	}
	
	@Bean
	IUbicacionUseCase UbicacionUseCase(IUbicacionRepositorio ubiRepositorio) {
		return new UbicacionUseCaseImpl(ubiRepositorio);
	}
	
	@Bean
	IMovimientoRepositorio MovimientoRepositorio(IMovimientoJpaRepository movimientoJpaRepositorio, IMovimientoJpaMapper movimientoJpaMapper) {
		return new MovimientoRepositorioImpl(movimientoJpaRepositorio,movimientoJpaMapper);
	}
	
	@Bean
	IMovimientoUseCase MovimientoUseCase(IMovimientoRepositorio movimientoRepositorio) {
		return new MovimientoUseCaseImpl(movimientoRepositorio);
	}
	
	@Bean
	IMovimientoDetalleRepositorio MovimientoDetalleRepositorio(IMovimientoDetalleJpaRepository movDetJpaRepositorio, IMovimientoDetalleJpaMapper movDetJpaMapper) {
		return new MovimientoDetalleRepositorioImpl(movDetJpaRepositorio,movDetJpaMapper);
	}
	
	@Bean
	IMovimientoDetalleUseCase MovimientoDetalleUseCase(IMovimientoDetalleRepositorio movDetRepositorio) {
		return new MovimientoDetalleUseCaseImpl(movDetRepositorio);
	}
}
