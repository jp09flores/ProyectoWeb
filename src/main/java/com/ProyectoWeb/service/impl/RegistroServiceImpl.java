package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.CorreoService;
import com.ProyectoWeb.service.RegistroService;
import com.ProyectoWeb.service.UsuarioService;
import jakarta.mail.MessagingException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private CorreoService correoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private MessageSource messageSource;  

    

    @Override
    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException {
        String mensaje;
        if (!usuarioService.existeUsuarioPorUsernameOCorreo(usuario.getUsername(), usuario.getCorreo())) {
            var codigo = new BCryptPasswordEncoder();
            usuario.setPassword(codigo.encode(usuario.getPassword()));

            usuarioService.save(usuario, true);
            
            
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.activacion.ok",
                            null,
                            Locale.getDefault()),
                    usuario.getCorreo());
        } else {
            mensaje = String.format(
                    messageSource.getMessage(
                            "registro.mensaje.usuario.o.correo",
                            null,
                            Locale.getDefault()),
                    usuario.getUsername(), usuario.getCorreo());
        }
        model.addAttribute(
                "titulo",
                messageSource.getMessage(
                        "registro.activar",
                        null,
                        Locale.getDefault()));
        model.addAttribute(
                "mensaje",
                mensaje);
        return model;
    }

   

   

   
    @Value("${servidor.http}")
    private String servidor;

   

    
}