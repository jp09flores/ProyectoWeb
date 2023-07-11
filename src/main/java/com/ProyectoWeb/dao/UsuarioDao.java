package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

}
