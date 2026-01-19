package com.aliengnss.backend.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IClienteUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoDetalleUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.ICompraProductoUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IDetalleVentaUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IInventarioMovimientoUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoDetalleUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoSeriesUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoSerialUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IProductoUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IUbicacionUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IUsuarioUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaDetalleSerialUseCase;
import com.aliengnss.backend.aplicacion.casosuso.entrada.IVentaUseCase;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.ClienteUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.CompraProductoDetalleUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.CompraProductoUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.DetalleVentaUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.InventarioMovimientoUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.MovimientoDetalleUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.MovimientoSeriesUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.MovimientoUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.ProductoSerialUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.ProductoUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.UbicacionUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.UsuarioUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.VentaDetalleSerialUseCaseImpl;
import com.aliengnss.backend.aplicacion.casosuso.implementacion.VentaUseCaseImpl;
import com.aliengnss.backend.dominio.repositorios.IClienteRepositorio;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoDetalleRepositorio;
import com.aliengnss.backend.dominio.repositorios.ICompraProductoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IDetalleVentaRepositorio;
import com.aliengnss.backend.dominio.repositorios.IInventarioMovimientoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IMovimientoSeriesRepositorio;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IProductoSerialRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUsuarioRepositorio;
import com.aliengnss.backend.dominio.repositorios.IVentaDetalleSerialRepositorio;
import com.aliengnss.backend.dominio.repositorios.IVentaRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.CompraProductoDetalleRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.CompraProductoRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.DetalleVentaRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.InventarioMovimientoRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.MovimientoDetalleRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.MovimientoRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.MovimientoSeriesRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.ProductoSerialRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.UbicacionRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.VentaDetalleSerialRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.adaptadores.VentaRepositorioImpl;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.ICompraProductoJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IDetalleVentaJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IInventarioMovimientoJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoDetalleJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IMovimientoSeriesJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IProductoSerialJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IUbicacionJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IVentaDetalleSerialJpaMapper;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IVentaJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IClienteJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoDetalleJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.ICompraProductoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IDetalleVentaJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IInventarioMovimientoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoDetalleJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IMovimientoSeriesJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IProductoJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IProductoSerialJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IUbicacionJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IUsuarioJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IVentaDetalleSerialJpaRepository;
import com.aliengnss.backend.infraestructura.repositorios.IVentaJpaRepository;

@Configuration
public class ConfiguracionGeneral {

	@Bean
	IClienteRepositorio clienteRepositorio(IClienteJpaRepository clienteJpaRepository,
			IClienteJpaMapper clienteJpaMapper) {
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
	IDetalleVentaRepositorio detalleVentaRepositorio(IDetalleVentaJpaRepository detalleVentaJpaRepository,
			IDetalleVentaJpaMapper detalleVentaJpaMapper) {
		return new DetalleVentaRepositorioImpl(detalleVentaJpaRepository, detalleVentaJpaMapper);
	}

	@Bean
	IDetalleVentaUseCase detalleVentaUseCase(IDetalleVentaRepositorio detalleVentaRepositorio) {
		return new DetalleVentaUseCaseImpl(detalleVentaRepositorio);
	}

	@Bean
	IProductoRepositorio productoRepositorio(IProductoJpaRepository productoJpaRepository,
			IProductoJpaMapper productoJpaMapper) {
		return new ProductoRepositorioImpl(productoJpaRepository, productoJpaMapper);
	}

	@Bean
	IProductoUseCase productoUseCase(IProductoRepositorio productoRepositorio) {
		return new ProductoUseCaseImpl(productoRepositorio);
	}
	
	@Bean
    IProductoSerialRepositorio productoSerialRepositorio(IProductoSerialJpaRepository productoSerialJpaRepository, IProductoSerialJpaMapper productoSerialJpaMapper) {
    	return new ProductoSerialRepositorioImpl(productoSerialJpaRepository, productoSerialJpaMapper);
    }
    
    @Bean
    IProductoSerialUseCase productoSerialUseCase(IProductoSerialRepositorio productoSerialRepositorio) {
    	return new ProductoSerialUseCaseImpl(productoSerialRepositorio);
    }
    
    @Bean
    IMovimientoSeriesRepositorio movimientoSeriesRepositorio(IMovimientoSeriesJpaRepository movimientoSeriesJpaRepository, IMovimientoSeriesJpaMapper movimientoSeriesJpaMapper) {
    	return new MovimientoSeriesRepositorioImpl(movimientoSeriesJpaRepository, movimientoSeriesJpaMapper);
    }
    
    @Bean
    IMovimientoSeriesUseCase movimientoSeriesUseCase(IMovimientoSeriesRepositorio movimientoSeriesRepositorio) {
    	return new MovimientoSeriesUseCaseImpl(movimientoSeriesRepositorio);
    }

	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepository usuarioJpaRepository,
			IUsuarioJpaMapper usuarioJpaMapper) {
		return new UsuarioRepositorioImpl(usuarioJpaRepository, usuarioJpaMapper);
	}

	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio usuarioRepositorio) {
		return new UsuarioUseCaseImpl(usuarioRepositorio);
	}

	@Bean
	ICompraProductoRepositorio cpRepositorio(ICompraProductoJpaRepository cpJpaRepository,
			ICompraProductoJpaMapper cpJpaMapper) {
		return new CompraProductoRepositorioImpl(cpJpaRepository, cpJpaMapper);
	}

	@Bean
	ICompraProductoUseCase cpUseCase(ICompraProductoRepositorio cpRepositorio) {
		return new CompraProductoUseCaseImpl(cpRepositorio);
	}

	@Bean
	ICompraProductoDetalleRepositorio cpdRepositorio(ICompraProductoDetalleJpaRepository cpdJpaRepository,
			ICompraProductoDetalleJpaMapper cpdJpaMapper) {
		return new CompraProductoDetalleRepositorioImpl(cpdJpaRepository, cpdJpaMapper);
	}

	@Bean
	ICompraProductoDetalleUseCase cpdUseCase(ICompraProductoDetalleRepositorio cpdRepositorio) {
		return new CompraProductoDetalleUseCaseImpl(cpdRepositorio);
	}

	@Bean
	IUbicacionRepositorio UbicacionRepositorio(IUbicacionJpaRepository ubiJpaRepositorio,
			IUbicacionJpaMapper ubiJpaMapper) {
		return new UbicacionRepositorioImpl(ubiJpaRepositorio, ubiJpaMapper);
	}

	@Bean
	IUbicacionUseCase UbicacionUseCase(IUbicacionRepositorio ubiRepositorio) {
		return new UbicacionUseCaseImpl(ubiRepositorio);
	}

	@Bean
	IMovimientoRepositorio MovimientoRepositorio(IMovimientoJpaRepository movimientoJpaRepositorio,
			IMovimientoJpaMapper movimientoJpaMapper) {
		return new MovimientoRepositorioImpl(movimientoJpaRepositorio, movimientoJpaMapper);
	}

	@Bean
	IMovimientoUseCase movimientoUseCase(
		IMovimientoRepositorio movimientoRepositorio
	) {
	    return new MovimientoUseCaseImpl(
		    movimientoRepositorio
	    );
	}


	@Bean
	IMovimientoDetalleRepositorio MovimientoDetalleRepositorio(IMovimientoDetalleJpaRepository movDetJpaRepositorio,
			IMovimientoDetalleJpaMapper movDetJpaMapper) {
		return new MovimientoDetalleRepositorioImpl(movDetJpaRepositorio, movDetJpaMapper);
	}

	@Bean
	IMovimientoDetalleUseCase MovimientoDetalleUseCase(IMovimientoDetalleRepositorio movDetRepositorio) {
		return new MovimientoDetalleUseCaseImpl(movDetRepositorio);
	}
	
	@Bean
	IVentaDetalleSerialRepositorio ventaDetalleSerialRepositorio(IVentaDetalleSerialJpaRepository ventaDetalleSerialJpaRepository,
			IVentaDetalleSerialJpaMapper ventaDetalleSerialJpaMapper) {
		return new VentaDetalleSerialRepositorioImpl(ventaDetalleSerialJpaRepository, ventaDetalleSerialJpaMapper);
	}

	@Bean
	IVentaDetalleSerialUseCase ventaDetalleSerialUseCase(IVentaDetalleSerialRepositorio ventaDetalleSerialRepositorio) {
		return new VentaDetalleSerialUseCaseImpl(ventaDetalleSerialRepositorio);
	}
	
	@Bean
	IInventarioMovimientoRepositorio inventarioMovimientoRepositorio(IInventarioMovimientoJpaRepository inventarioMovimientoJpaRepository,
			IInventarioMovimientoJpaMapper inventarioMovimientoJpaMapper) {
		return new InventarioMovimientoRepositorioImpl(inventarioMovimientoJpaRepository, inventarioMovimientoJpaMapper);
	}

	@Bean
	IInventarioMovimientoUseCase inventarioMovimientoSerialUseCase(IInventarioMovimientoRepositorio inventarioMovimientoRepositorio) {
		return new InventarioMovimientoUseCaseImpl(inventarioMovimientoRepositorio);
	}
	
	

}
