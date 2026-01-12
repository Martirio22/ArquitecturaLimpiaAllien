package com.aliengnss.backend.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoDetalleUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.CompraProductoDetalleUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.CompraProductoUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.UsuarioUseCaseImpl;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoDetalleRepositorio;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUsuarioRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.CompraProductoDetalleRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.CompraProductoRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoDetalleJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IUsuarioJpaRepository;

@Configuration
public class ConfiguracionGeneral {

	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepository usuarioJpaRepository, IUsuarioJpaMapper usuarioJpaMapper) {
		return new UsuarioRepositorioImpl(usuarioJpaRepository, usuarioJpaMapper);
	}
	
	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio usuarioRepositorio) {
		return new UsuarioUseCaseImpl(usuarioRepositorio);
	}
	
	@Bean
	ICompraProductoRepositorio cpRepositorio(ICompraProductoJpaRepository cpJpaRepository, ICompraProductoJpaMapper cpJpaMapper) {
		return new CompraProductoRepositorioImpl(cpJpaRepository, cpJpaMapper);
	}
	
	@Bean
	ICompraProductoUseCase cpUseCase(ICompraProductoRepositorio cpRepositorio) {
		return new CompraProductoUseCaseImpl(cpRepositorio);
	}
	
	@Bean
	ICompraProductoDetalleRepositorio cpdRepositorio(ICompraProductoDetalleJpaRepository cpdJpaRepository, ICompraProductoDetalleJpaMapper cpdJpaMapper) {
		return new CompraProductoDetalleRepositorioImpl(cpdJpaRepository, cpdJpaMapper);
	}
	
	@Bean
	ICompraProductoDetalleUseCase cpdUseCase(ICompraProductoDetalleRepositorio cpdRepositorio) {
		return new CompraProductoDetalleUseCaseImpl(cpdRepositorio);
	}
}
