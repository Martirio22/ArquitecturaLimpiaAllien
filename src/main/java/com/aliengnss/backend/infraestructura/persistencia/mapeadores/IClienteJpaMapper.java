package com.aliengnss.backend.infraestructura.persistencia.mapeadores;

import com.aliengnss.backend.dominio.entidades.Cliente;
import com.aliengnss.backend.infraestructura.persistencia.jpa.ClienteJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IClienteJpaMapper {
    Cliente toDomain(ClienteJpa entity);
    ClienteJpa toEntity(Cliente cliente);
}
