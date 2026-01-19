package com.aliengnss.backend.aplicacion.casosuso.entrada;

import java.util.List;

import com.aliengnss.backend.dominio.entidades.Cliente;

public interface IClienteUseCase {

    Cliente guardar(Cliente cliente);
    Cliente buscarPorId(Long idCliente);
    List<Cliente> listarTodos();
    void eliminar(Long idCliente);

    Cliente buscarPorDocumento(String documento);
    Cliente buscarPorEmail(String email);
    Cliente buscarPorTelefono(String telefono);

    List<Cliente> buscarPorPrimerNombre(String primerNombre);
    List<Cliente> buscarPorPrimerApellido(String primerApellido);

    List<Cliente> buscarPorNombreYApellido(String primerNombre, String primerApellido);
    List<Cliente> buscarPorDocumentoYApellido(String documento, String primerApellido);
    List<Cliente> buscarPorTelefonoYDocumento(String telefono, String documento);
    List<Cliente> buscarPorEmailYDocumento(String email, String documento);

    List<Cliente> buscarPorNombreOApellidoODocumento(String texto);
}
