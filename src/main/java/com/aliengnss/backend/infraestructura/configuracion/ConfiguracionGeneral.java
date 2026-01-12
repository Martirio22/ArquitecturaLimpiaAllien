package com.aliengnss.backend.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.aliengnss.backend.aplicacion.casosuso.entrada.IClienteUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IDetalleVentaUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.ClienteUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.DetalleVentaUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.ProductoUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.VentaUseCaseImpl;
import com.aliengnss.backend.dominio.repositorios.IClienteRepositorio;
import com.aliengnss.backend.dominio.repositorios.IDetalleVentaRepositorio;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.DetalleVentaRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.VentaRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IDetalleVentaJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IVentaJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IClienteJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IDetalleVentaJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IProductoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IVentaJpaRepository;
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
    IClienteRepositorio clienteRepositorio(IClienteJpaRepository clienteJpaRepository, IClienteJpaMapper clienteJpaMapper) {
        return new ClienteRepositorioImpl(clienteJpaRepository, clienteJpaMapper);
    }

    @Bean
    IClienteUseCase clienteUseCase(IClienteRepositorio clienteRepositorio) {
        return new ClienteUseCaseImpl(clienteRepositorio);
    }

    @Bean
    IVentaRepositorio ventaRepositorio(IVentaJpaRepository ventaJpaRepository, IVentaJpaMapper ventaJpaMapper) {
        return new VentaRepositorioImpl(ventaJpaRepository, ventaJpaMapper);
    }

    @Bean
    IVentaUseCase ventaUseCase(IVentaRepositorio ventaRepositorio) {
        return new VentaUseCaseImpl(ventaRepositorio);
    }

    @Bean
    IDetalleVentaRepositorio detalleVentaRepositorio(IDetalleVentaJpaRepository detalleVentaJpaRepository, IDetalleVentaJpaMapper detalleVentaJpaMapper) {
        return new DetalleVentaRepositorioImpl(detalleVentaJpaRepository, detalleVentaJpaMapper);
    }

    @Bean
    IDetalleVentaUseCase detalleVentaUseCase(IDetalleVentaRepositorio detalleVentaRepositorio) {
        return new DetalleVentaUseCaseImpl(detalleVentaRepositorio);
    }

    

    @Bean
    IProductoRepositorio productoRepositorio(IProductoJpaRepository productoJpaRepository, IProductoJpaMapper productoJpaMapper) {
        return new ProductoRepositorioImpl(productoJpaRepository, productoJpaMapper);
    }

    @Bean
    IProductoUseCase productoUseCase(IProductoRepositorio productoRepositorio) {
        return new ProductoUseCaseImpl(productoRepositorio);
    }
    
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
