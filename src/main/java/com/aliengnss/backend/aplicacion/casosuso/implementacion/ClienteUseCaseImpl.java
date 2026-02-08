package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IClienteUseCase;
import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.dominio.repositorios.IClienteRepositorio;


public class ClienteUseCaseImpl implements IClienteUseCase {

    private final IClienteRepositorio repo;

    public ClienteUseCaseImpl(IClienteRepositorio repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Cliente guardar(Cliente cliente) {

        boolean esNuevo = (cliente.getIdCliente() == null);

        if (esNuevo) {
            // Unicidad (nuevo)
            repo.buscarPorDocumento(cliente.getDocumento())
                .ifPresent(c -> { throw new RuntimeException("El documento ya está registrado"); });

            repo.buscarPorEmail(cliente.getEmail())
                .ifPresent(c -> { throw new RuntimeException("El email ya está registrado"); });

            repo.buscarPorTelefono(cliente.getTelefono())
                .ifPresent(c -> { throw new RuntimeException("El teléfono ya está registrado"); });

            // Defaults
            cliente = new Cliente(
                null,
                cliente.getPrimerNombre(), cliente.getSegundoNombre(),
                cliente.getPrimerApellido(), cliente.getSegundoApellido(),
                cliente.getDocumento(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getDireccion(),
                true
            );

        } else {
            Cliente existente = buscarPorId(cliente.getIdCliente());

            // Si cambió documento
            if (!existente.getDocumento().equals(cliente.getDocumento())) {
                repo.buscarPorDocumento(cliente.getDocumento())
                    .ifPresent(c -> { throw new RuntimeException("El documento ya está registrado"); });
            }

            // Si cambió email
            if (!existente.getEmail().equalsIgnoreCase(cliente.getEmail())) {
                repo.buscarPorEmail(cliente.getEmail())
                    .ifPresent(c -> { throw new RuntimeException("El email ya está registrado"); });
            }

            // Si cambió telefono
            if (!existente.getTelefono().equals(cliente.getTelefono())) {
                repo.buscarPorTelefono(cliente.getTelefono())
                    .ifPresent(c -> { throw new RuntimeException("El teléfono ya está registrado"); });
            }

            // Reconstruir manteniendo esActivo
            cliente = new Cliente(
                existente.getIdCliente(),
                cliente.getPrimerNombre(), cliente.getSegundoNombre(),
                cliente.getPrimerApellido(), cliente.getSegundoApellido(),
                cliente.getDocumento(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getDireccion(),
                existente.getEsActivo()
            );
        }

        return repo.guardar(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long idCliente) {
        return repo.buscarPorId(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + idCliente));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listarTodos() {
        return repo.listarTodos();
    }

    @Override
    @Transactional
    public void eliminar(Long idCliente) {
        // 1. Buscamos el cliente existente
        Cliente existente = buscarPorId(idCliente);
        
        // 2. Creamos una nueva instancia con los mismos datos pero con esActivo en false
        Cliente clienteDesactivado = new Cliente(
            existente.getIdCliente(),
            existente.getPrimerNombre(),
            existente.getSegundoNombre(),
            existente.getPrimerApellido(),
            existente.getSegundoApellido(),
            existente.getDocumento(),
            existente.getTelefono(),
            existente.getEmail(),
            existente.getDireccion(),
            false // <--- Estado desactivado
        );
        
        // 3. Guardamos los cambios (esto hará un UPDATE en la DB)
        repo.guardar(clienteDesactivado);
    }

}
