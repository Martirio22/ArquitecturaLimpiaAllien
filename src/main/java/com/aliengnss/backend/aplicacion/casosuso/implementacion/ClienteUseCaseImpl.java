package com.aliengnss.backend.aplicacion.casosuso.implementacion;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliengnss.backend.aplicacion.casosuso.entrada.IClienteUseCase;
import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.dominio.repositorios.IClienteRepositorio;

@Service
@Transactional
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

    @Override
    public Cliente buscarPorDocumento(String documento) {
        return repo.buscarPorDocumento(documento)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado por documento: " + documento));
    }

    @Override
    public Cliente buscarPorEmail(String email) {
        return repo.buscarPorEmail(email)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado por email: " + email));
    }

    @Override
    public Cliente buscarPorTelefono(String telefono) {
        return repo.buscarPorTelefono(telefono)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado por telefono: " + telefono));
    }

    @Override
    public List<Cliente> buscarPorPrimerNombre(String primerNombre) {
        return repo.buscarPorPrimerNombre(primerNombre);
    }

    @Override
    public List<Cliente> buscarPorPrimerApellido(String primerApellido) {
        return repo.buscarPorPrimerApellido(primerApellido);
    }

    @Override
    public List<Cliente> buscarPorNombreYApellido(String primerNombre, String primerApellido) {
        return repo.buscarPorNombreYApellido(primerNombre, primerApellido);
    }

    @Override
    public List<Cliente> buscarPorDocumentoYApellido(String documento, String primerApellido) {
        return repo.buscarPorDocumentoYApellido(documento, primerApellido);
    }

    @Override
    public List<Cliente> buscarPorTelefonoYDocumento(String telefono, String documento) {
        return repo.buscarPorTelefonoYDocumento(telefono, documento);
    }

    @Override
    public List<Cliente> buscarPorEmailYDocumento(String email, String documento) {
        return repo.buscarPorEmailYDocumento(email, documento);
    }

    @Override
    public List<Cliente> buscarPorNombreOApellidoODocumento(String texto) {
        return repo.buscarPorNombreOApellidoODocumento(texto);
    }
}
