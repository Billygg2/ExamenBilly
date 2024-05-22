package com.billy.tiendavirtualmike.VentaBilly;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServiceBilly {

    @Autowired
    private VentaRepositoryBilly ventaRepositoryBilly;

    public List<VentaBilly> getAllVentasBilly() {
        return ventaRepositoryBilly.findAll();
    }

    public VentaBilly insertVentaBilly(VentaBilly venta) {
        return ventaRepositoryBilly.save(venta);
    }

    public VentaBilly patchUpdateVenta(Long id, VentaBilly venta) {
        VentaBilly existingVenta = ventaRepositoryBilly.findById(id).orElse(null);
        if (existingVenta == null) {
            // Manejar el caso en el que la venta no se encuentre
            return null;
        }
        // Copiar las propiedades no nulas de venta a la venta existente
        BeanUtils.copyProperties(venta, existingVenta, "id");
        return ventaRepositoryBilly.save(existingVenta);
    }
    
    public void deleteByNombreBilly(String nombre){
        VentaBilly venta = ventaRepositoryBilly.findBynombre(nombre)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
                ventaRepositoryBilly.delete(venta);
    }
}
