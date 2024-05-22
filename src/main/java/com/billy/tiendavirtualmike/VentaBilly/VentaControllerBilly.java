package com.billy.tiendavirtualmike.VentaBilly;

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
@RequestMapping(value = "/api")
@Tag(name = "Controlador de Ventas Billy")
public class VentaControllerBilly {
    @Autowired
    private VentaServiceBilly ventaServiceBilly;

    @Operation(summary = "Obtiene todas las Ventas")
    @GetMapping("/VentaBilly")
    public List<VentaBilly> getAllVentaBilly() {
        return ventaServiceBilly.getAllVentasBilly();
    }

    @Operation(summary = "Crea y guarda un nueva Venta")
    @PostMapping("/VentaBilly")
    public VentaBilly insertVentaBilly(@RequestBody VentaBilly ventaBilly) {
        return ventaServiceBilly.insertVentaBilly(ventaBilly);
    }

    @Operation(summary = "Edita los campos de una Venta por ID")
    @PatchMapping("/VentaBilly/{id}")
    public ResponseEntity<VentaBilly> patchUpdateVenta(@PathVariable Long id, @RequestBody VentaBilly venta) {
        VentaBilly updatedVenta = ventaServiceBilly.patchUpdateVenta(id, venta);
        if (updatedVenta == null) {
            // Manejar el caso en el que la venta no se encuentre
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedVenta);
    }

    @Operation(summary = "Elimina una Venta por el Nombre del Producto")
    @DeleteMapping("/VentaBilly/{nombre}")
    public ResponseEntity<Void> delete(@PathVariable String nombre) {
        ventaServiceBilly.deleteByNombreBilly(nombre);
        return ResponseEntity.noContent().build();
    }
}
