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
        if (cliente.getIdCliente() == null) {
            // Nuevo cliente: forzar true
            cliente = new Cliente(
                null, cliente.getPrimerNombre(), cliente.getSegundoNombre(),
                cliente.getPrimerApellido(), cliente.getSegundoApellido(),
                cliente.getDocumento(), cliente.getTelefono(),
                cliente.getEmail(), cliente.getDireccion(),
                true // activo por defecto
            );
        } else {
            // Edición: mantener el estado que ya tenía
            Cliente existente = buscarPorId(cliente.getIdCliente());
            cliente = new Cliente(
                existente.getIdCliente(), cliente.getPrimerNombre(), cliente.getSegundoNombre(),
                cliente.getPrimerApellido(), cliente.getSegundoApellido(),
                cliente.getDocumento(), cliente.getTelefono(),
                cliente.getEmail(), cliente.getDireccion(),
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
