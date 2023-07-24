
package com.ProyectoWeb.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Long idComentario;
    private String fechaEmision;
    private String detalleComentario;
    private int valoracion;
    private boolean estado;
    
     public Comentario() {
    }

    public Comentario(String fechaEmision, String detalleComentario, int valoracion, boolean estado) {
        this.fechaEmision = fechaEmision;
        this.detalleComentario = detalleComentario;
        this.valoracion = valoracion;
        this.estado = estado;
    }
     
}
