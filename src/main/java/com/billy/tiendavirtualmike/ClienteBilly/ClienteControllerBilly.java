package com.billy.tiendavirtualmike.ClienteBilly;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping(value = "/api/")
@Tag(name = "Controlador de Clientes Billy")
public class ClienteControllerBilly {
    @Autowired
    private ClienteServiceBilly clienteServiceBilly;

    @Operation(summary = "Obtiene todos los Clientes")
    @GetMapping("/getAllClienteBilly")
    public List<ClienteBilly> getAllClienteBilly() {
        return clienteServiceBilly.getAllClientesBilly();
    }

    @Operation(summary = "Obtiene todos los Clientes")
    @PostMapping("/insertClienteBilly")
    public ClienteBilly insertClienteBilly(@RequestBody ClienteBilly clienteBilly) {
        return clienteServiceBilly.insertClienteBilly(clienteBilly);
    }

    @Operation(summary = "Edita los campos de un Cliente por ID")
    @PatchMapping("/updateClienteBilly/{id}")
    public ResponseEntity<ClienteBilly> patchUpdateClienteBilly(@PathVariable Long id, @RequestBody ClienteBilly cliente) {
        ClienteBilly updatedCliente = clienteServiceBilly.patchUpdateClienteBilly(id, cliente);
        if (updatedCliente == null) {
            // Manejar el caso en el que el cliente no se encuentre
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCliente);
    }

    @Operation(summary = "Elimina un Cliente por ID")
    @DeleteMapping("/deleteClienteBilly/{id}")
    public ResponseEntity<Void> deleteClienteBilly(@PathVariable Long id) {
        clienteServiceBilly.deleteClienteBilly(id);
        return ResponseEntity.noContent().build();
    }
}
