package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;

public interface RegistroService {

  

    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;

    
}
