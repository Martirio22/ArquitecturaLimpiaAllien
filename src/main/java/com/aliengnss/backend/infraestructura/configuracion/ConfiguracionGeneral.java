package com.aliengnss.backend.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IClienteUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IDetalleVentaUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.ClienteUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.DetalleVentaUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.VentaUseCaseImpl;
import com.aliengnss.backend.dominio.repositorios.IClienteRepositorio;
import com.aliengnss.backend.dominio.repositorios.IDetalleVentaRepositorio;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.DetalleVentaRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.VentaRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IDetalleVentaJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IVentaJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IClienteJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IDetalleVentaJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IVentaJpaRepository;

@Configuration
public class ConfiguracionGeneral {
	// entidades Christian
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

 // entidades Martin
 // entidades Shaden
 // entidades Anthony
    

}
