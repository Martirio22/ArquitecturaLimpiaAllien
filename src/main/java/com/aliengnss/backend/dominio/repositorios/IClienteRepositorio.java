package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Cliente;

public interface IClienteRepositorio {

    Cliente guardar(Cliente cliente);
    Optional<Cliente> buscarPorId(Long idCliente);
    List<Cliente> listarTodos();
    void eliminar(Long idCliente);

}
