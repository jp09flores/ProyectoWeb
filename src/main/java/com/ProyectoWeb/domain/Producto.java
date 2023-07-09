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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    private String nombreProducto;
    private double precio;
    private String rutaImagen;
    private boolean estado;
    
    @ManyToOne
    @JoinColumn(name= "id_categoria")
    private Categoria categoria;
    
    
    @OneToMany
    @JoinColumn(name = "id_producto")
    private List<DetallePedido> detallePedido;

    public Producto() {
    }

    public Producto(String nombreProducto, double precio, String rutaImagen, boolean estado, Categoria categoria) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.estado = estado;
        this.categoria = categoria;
    }
    
    
}
