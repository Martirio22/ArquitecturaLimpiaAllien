package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IClienteUseCase;
import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.dominio.repositorios.IClienteRepositorio;

import java.util.List;
import java.util.Optional;

public class ClienteUseCaseImpl implements IClienteUseCase {

    private final IClienteRepositorio clienteRepositorio;

    public ClienteUseCaseImpl(IClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.guardar(cliente);
    }

    @Override
    public Cliente buscarPorId(Long idCliente) {
        return clienteRepositorio.buscarPorId(idCliente).orElseThrow(() -> new RuntimeException("No existe el cliente con el id " + idCliente));
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepositorio.listarTodos();
    }

    @Override
    public void eliminar(Long idCliente) {
        clienteRepositorio.eliminar(idCliente);
    }
}
