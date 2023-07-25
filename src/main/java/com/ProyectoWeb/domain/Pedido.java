package com.ProyectoWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pedido")
    private Long idPedido;
    private String fechaEmision;
    private double total;
    private boolean estado;
    
    
    @OneToMany
    @JoinColumn(name = "id_pedido")
    private List<DetallePedido> detallePedidos;

    public Pedido() {
    }

    public Pedido(String fechaEmision, double total, boolean estado) {
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.estado = estado;
    }
    
    
    
    
}
