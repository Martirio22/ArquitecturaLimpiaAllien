package com.aliengnss.backend.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Cliente;

public interface IClienteRepositorio {

    Cliente guardar(Cliente cliente);
    Optional<Cliente> buscarPorId(Long idCliente);
    List<Cliente> listarTodos();
    void eliminar(Long idCliente);

    Optional<Cliente> buscarPorDocumento(String documento);
    Optional<Cliente> buscarPorEmail(String email);
    Optional<Cliente> buscarPorTelefono(String telefono);

    List<Cliente> buscarPorPrimerNombre(String primerNombre);
    List<Cliente> buscarPorPrimerApellido(String primerApellido);

    List<Cliente> buscarPorNombreYApellido(String primerNombre, String primerApellido);
    List<Cliente> buscarPorDocumentoYApellido(String documento, String primerApellido);
    List<Cliente> buscarPorTelefonoYDocumento(String telefono, String documento);
    List<Cliente> buscarPorEmailYDocumento(String email, String documento);

    List<Cliente> buscarPorNombreOApellidoODocumento(String texto);
}
