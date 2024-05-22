package com.billy.tiendavirtualmike.VentaBilly;

import java.util.Date;

import com.billy.tiendavirtualmike.ClienteBilly.ClienteBilly;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class VentaBilly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String nombre;
    private boolean estado;
    private int cantidad; 

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteBilly cliente;

}
