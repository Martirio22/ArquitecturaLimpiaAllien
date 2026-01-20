package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Cliente;

public interface IClienteUseCase {

    Cliente guardar(Cliente cliente);
    Cliente buscarPorId(Long idCliente);
    List<Cliente> listarTodos();
    void eliminar(Long idCliente);

}
