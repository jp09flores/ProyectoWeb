package com.ProyectoWeb.service;

import jakarta.mail.MessagingException;

public interface CorreoService {
    public void enviarCorreo(
            String para, 
            String asunto, 
            String contenidoHtml) 
            throws MessagingException;
}