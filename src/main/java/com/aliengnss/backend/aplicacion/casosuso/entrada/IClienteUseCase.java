package com.aliengnss.backend.aplicacion.casosuso.entrada;

import com.aliengnss.backend.dominio.entidades.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteUseCase {
    Cliente guardar(Cliente cliente);
    Cliente buscarPorId(Long idCliente);
    List<Cliente> listarTodos();
    void eliminar(Long idCliente);
}
