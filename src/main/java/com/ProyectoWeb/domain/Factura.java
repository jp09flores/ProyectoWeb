/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author jp09f
 */

@Data
@Entity
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Long idFactura;
    private String fecha;
    private double total;
    private boolean estado;
    private String tipoTarjeta;
    private int numTarjeta;
    private String nombreTarjeta;
   
    
    
    @ManyToOne
    @JoinColumn(name= "id_pedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    public Factura() {
    }

    public Factura(String fecha, double total, boolean estado, String tipoTarjeta, int numTarjeta, String nombreTarjeta) {
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.tipoTarjeta = tipoTarjeta;
        this.numTarjeta = numTarjeta;
        this.nombreTarjeta = nombreTarjeta;
    }


    
    
    
}
