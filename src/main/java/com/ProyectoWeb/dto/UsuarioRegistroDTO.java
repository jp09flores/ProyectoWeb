package com.ProyectoWeb.dto;

import lombok.Data;

@Data
public class UsuarioRegistroDTO {

    private Long idUsuario;
    private String nombreUsuario;
    private String primer_apellido;
    private String segundo_apellido;
    private String email;
    private String pass;
    private boolean activo;

    public UsuarioRegistroDTO(Long idUsuario, String nombreUsuario, String primer_apellido, String segundo_apellido, String email, String pass, boolean activo) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.email = email;
        this.pass = pass;
    }

    public UsuarioRegistroDTO(String nombreUsuario, String primer_apellido, String segundo_apellido, String email, String pass) {
        this.nombreUsuario = nombreUsuario;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.email = email;
        this.pass = pass;
    }

    public UsuarioRegistroDTO(String email) {
        this.email = email;
    }

    public UsuarioRegistroDTO() {
    }

}
