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
    public Cliente guardar(Cliente cliente) {
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
    public void eliminar(Long idCliente) {
        repo.eliminar(idCliente);
    }

}
