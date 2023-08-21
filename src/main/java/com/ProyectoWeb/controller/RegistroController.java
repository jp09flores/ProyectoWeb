package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.RegistroService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @GetMapping("/nuevo")
    public String nuevo(Model model, Usuario usuario) {
        return "/registro/nuevo";
    }


    @PostMapping("/crearUsuario")
    public String crearUsuario(Model model, Usuario usuario) throws MessagingException {
        model = registroService.crearUsuario(model, usuario);
        return "/registro/salida";
    }

    


}
