package com.ProyectoWeb.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    
    @Column(name = "nombre_Usuario")
    private String nombreUsuario;
    
    @Column(name = "primer_apellido")
    private String primer_apellido;
    
    @Column(name = "segundo_apellido")
    private String segundo_apellido;
    private String email;
    private String pass;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "id_us", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_r", referencedColumnName = "id_rol"))
    private Collection<Rol> roles;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String primer_apellido, String segundo_apellido, String email, String pass, Collection<Rol> roles) {
        this.nombreUsuario = nombreUsuario;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.email = email;
        this.pass = pass;
        this.roles = roles;
    }


}
