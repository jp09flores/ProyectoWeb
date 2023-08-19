package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Formulario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;



public interface FormularioService {
    
    public void save(Formulario Formulario);
    
   }
