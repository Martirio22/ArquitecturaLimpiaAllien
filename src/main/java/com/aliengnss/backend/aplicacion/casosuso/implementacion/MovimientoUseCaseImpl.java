package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IMovimientoUseCase;
import com.aliengnss.backend.dominio.entidades.Movimiento;
import com.aliengnss.backend.dominio.entidades.MovimientoDetalle;
import com.aliengnss.backend.dominio.entidades.Producto;
import com.aliengnss.backend.dominio.entidades.Ubicacion;
import com.aliengnss.backend.dominio.entidades.Usuario;
import com.aliengnss.backend.dominio.repositorios.IMovimientoDetalleRepositorio;
import com.aliengnss.backend.dominio.repositorios.IMovimientoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IProductoRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUbicacionRepositorio;
import com.aliengnss.backend.dominio.repositorios.IUsuarioRepositorio;
import com.aliengnss.backend.presentacion.dto.req.MovimientoRequestDto;

public class MovimientoUseCaseImpl implements IMovimientoUseCase {

    private final IMovimientoRepositorio repo;
    private final IUbicacionRepositorio ubicacionRepositorio;
    private final IUsuarioRepositorio usuarioRepositorio;
    private final IProductoRepositorio productoRepositorio; // ✅ Nuevo
    private final IMovimientoDetalleRepositorio detalleRepo; // ✅ Nuevo

    public MovimientoUseCaseImpl(
            IMovimientoRepositorio repo,
            IUbicacionRepositorio ubicacionRepositorio,
            IUsuarioRepositorio usuarioRepositorio,
            IProductoRepositorio productoRepositorio,
            IMovimientoDetalleRepositorio detalleRepo) {
        this.repo = repo;
        this.ubicacionRepositorio = ubicacionRepositorio;
        this.usuarioRepositorio = usuarioRepositorio;
        this.productoRepositorio = productoRepositorio;
        this.detalleRepo = detalleRepo;
    }

    @Override
    @Transactional
    public Movimiento crear(MovimientoRequestDto dto) {
        // 1. Validaciones de cabecera
        Ubicacion origen = ubicacionRepositorio.buscarPorId(dto.getIdUbicacionOrigen())
                .orElseThrow(() -> new RuntimeException("Ubicación origen no existe"));

        Ubicacion destino = ubicacionRepositorio.buscarPorId(dto.getIdUbicacionDestino())
                .orElseThrow(() -> new RuntimeException("Ubicación destino no existe"));

        Usuario usuario = usuarioRepositorio.buscarPorId(dto.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        // 2. Crear y persistir cabecera inicial (sin detalles aún)
        Movimiento movimientoInicial = new Movimiento(
                null, // Se autogenera
                dto.getFechaMovimiento(),
                dto.getTipo(),
                dto.getObservaciones(),
                usuario,
                origen,
                destino);

        Movimiento movimientoGuardado = repo.guardar(movimientoInicial);

        // 3. Validar que haya detalles
        if (dto.getDetalles() == null || dto.getDetalles().isEmpty()) {
            throw new RuntimeException("No se puede crear un movimiento sin productos");
        }

        // 4. Procesar y guardar detalles
        List<MovimientoDetalle> detallesGuardados = dto.getDetalles().stream().map(detalleDto -> {
            Producto producto = productoRepositorio.buscarPorId(detalleDto.getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + detalleDto.getIdProducto()));

            // ✅ Crear el detalle
            MovimientoDetalle detalle = new MovimientoDetalle(
                    null, // Se autogenera
                    detalleDto.getCantidad(), // Integer
                    movimientoGuardado,
                    producto);

            // Guardar el detalle
            return detalleRepo.guardar(detalle);
        }).collect(Collectors.toList());

        System.out.println("✅ Movimiento guardado con " + detallesGuardados.size() + " detalles");

        return movimientoGuardado;
    }

    @Override
    @Transactional(readOnly = true)
    public Movimiento buscarPorId(Long idMovimiento) {
        // Buscar el movimiento
        Movimiento movimiento = repo.buscarPorId(idMovimiento)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));

        // ✅ Buscar los detalles asociados
        List<MovimientoDetalle> detalles = detalleRepo.buscarPorMovimiento(idMovimiento);

        // ✅ Retornar el movimiento con los detalles usando el constructor completo
        return new Movimiento(
                movimiento.getIdMovimiento(),
                movimiento.getFechaMovimiento(),
                movimiento.getTipo(),
                movimiento.getObservaciones(),
                movimiento.getFkUsuario(),
                movimiento.getFkUbicacionOrigen(),
                movimiento.getFkUbicacionDestino(),
                detalles // ✅ Incluir los detalles
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    @Transactional
    public void eliminar(Long idMovimiento) {
        repo.eliminar(idMovimiento);
    }

    @Override
    @Transactional
    public Movimiento actualizar(Movimiento movimiento) {
        return repo.guardar(movimiento);
    }
}