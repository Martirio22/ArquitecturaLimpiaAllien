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
    @Transactional
    public Cliente guardar(Cliente cliente) {
        // 1. Validar el documento (Cédula Ecuatoriana)
        if (!validarCedula(cliente.getDocumento())) {
            throw new RuntimeException("El documento ingresado no es una cédula ecuatoriana válida");
        }

        if (cliente.getIdCliente() == null) {
            // Nuevo cliente: forzar true
            cliente = new Cliente(
                null, cliente.getPrimerNombre(), cliente.getSegundoNombre(),
                cliente.getPrimerApellido(), cliente.getSegundoApellido(),
                cliente.getDocumento(), cliente.getTelefono(),
                cliente.getEmail(), cliente.getDireccion(),
                true // activo por defecto
            );
        } else {
            // Edición: mantener el estado que ya tenía
            Cliente existente = buscarPorId(cliente.getIdCliente());
            cliente = new Cliente(
                existente.getIdCliente(), cliente.getPrimerNombre(), cliente.getSegundoNombre(),
                existente.getPrimerApellido(), existente.getSegundoApellido(), // Corregido: usualmente se mantiene el apellido original o se usa el del objeto 'cliente' según tu lógica
                cliente.getDocumento(), cliente.getTelefono(),
                cliente.getEmail(), cliente.getDireccion(),
                existente.getEsActivo() 
            );
        }
        return repo.guardar(cliente);
    }

    // Reutilización del algoritmo de validación
    private boolean validarCedula(String cedula) {
        if (cedula == null || cedula.length() != 10) return false;
        try {
            int provincia = Integer.parseInt(cedula.substring(0, 2));
            if (provincia < 1 || provincia > 24) return false;
            
            int d10 = Integer.parseInt(cedula.substring(9, 10));
            int suma = 0;
            for (int i = 0; i < 9; i++) {
                int d = Integer.parseInt(cedula.substring(i, i + 1));
                if (i % 2 == 0) {
                    d = d * 2;
                    if (d > 9) d -= 9;
                }
                suma += d;
            }
            int residuo = suma % 10;
            int verificado = (residuo == 0) ? 0 : 10 - residuo;
            return verificado == d10;
        } catch (NumberFormatException e) { 
            return false; 
        }
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
    @Transactional
    public void eliminar(Long idCliente) {
        // 1. Buscamos el cliente existente
        Cliente existente = buscarPorId(idCliente);
        
        // 2. Creamos una nueva instancia con los mismos datos pero con esActivo en false
        Cliente clienteDesactivado = new Cliente(
            existente.getIdCliente(),
            existente.getPrimerNombre(),
            existente.getSegundoNombre(),
            existente.getPrimerApellido(),
            existente.getSegundoApellido(),
            existente.getDocumento(),
            existente.getTelefono(),
            existente.getEmail(),
            existente.getDireccion(),
            false // <--- Estado desactivado
        );
        
        // 3. Guardamos los cambios (esto hará un UPDATE en la DB)
        repo.guardar(clienteDesactivado);
    }

}
