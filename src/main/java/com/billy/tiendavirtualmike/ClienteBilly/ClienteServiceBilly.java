package com.billy.tiendavirtualmike.ClienteBilly;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceBilly {

    @Autowired
    private ClienteRepositoryBilly clienteRepositoryBilly;

    public List<ClienteBilly> getAllClientesBilly() {
        return clienteRepositoryBilly.findAll();
    }

    public ClienteBilly insertClienteBilly(ClienteBilly cliente) {
        return clienteRepositoryBilly.save(cliente);
    }

    public ClienteBilly patchUpdateClienteBilly(Long id, ClienteBilly cliente) {
        ClienteBilly existingCliente = clienteRepositoryBilly.findById(id).orElse(null);
        if (existingCliente == null) {
            // Manejar el caso en el que el cliente no se encuentre
            return null;
        }
        // Copiar las propiedades no nulas de cliente al cliente existente
        BeanUtils.copyProperties(cliente, existingCliente, "id");
        return clienteRepositoryBilly.save(existingCliente);
    }

    public void deleteClienteBilly(Long id) {
        clienteRepositoryBilly.deleteById(id);
    }

}
