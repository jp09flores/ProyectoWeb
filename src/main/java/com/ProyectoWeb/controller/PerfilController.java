package com.ProyectoWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
@Slf4j
public class PerfilController {
    
    @RequestMapping("/mostrar")
    public String PageMostrar (Model model) {
         return"/perfil/mostrar";
    }
    
    @RequestMapping("/editar")
    public String PageEditar (Model model) {
         return"/perfil/editar";
    }
}
