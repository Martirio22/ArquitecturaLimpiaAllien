package com.aliengnss.backend.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.dominio.repositorios.IClienteRepositorio;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ClienteJpa;
import com.aliengnss.backend.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.aliengnss.backend.infraestructura.repositorios.IClienteJpaRepository;

public class ClienteRepositorioImpl implements IClienteRepositorio {

    private final IClienteJpaRepository clienteJpaRepository;
    private final IClienteJpaMapper mapper;

    public ClienteRepositorioImpl(IClienteJpaRepository clienteJpaRepository, IClienteJpaMapper mapper) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        ClienteJpa entity = mapper.toEntity(cliente);
        ClienteJpa guardar = clienteJpaRepository.save(entity);
        return mapper.toDomain(guardar);
    }

    @Override
    public Optional<Cliente> buscarPorId(Long idCliente) {
        return clienteJpaRepository.findById(idCliente).map(mapper::toDomain);
    }

    @Override
    public List<Cliente> listarTodos() {
       return clienteJpaRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void eliminar(Long idCliente) {
        clienteJpaRepository.deleteById(idCliente);
    }
}
