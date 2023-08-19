package com.ProyectoWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="formulario")
public class Formulario implements Serializable{
    
    private static final long serialVersionUID =1L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_formulario")
    private Long idFormulario; // se transforma en id_formularios
    private String nombre;
    private String apellidos;
    private String correo;
    private int telefono;
    
  
    
    public Formulario() {
    }

    public Formulario(String nombre, String apellidos, String correo, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }


    
    
}
