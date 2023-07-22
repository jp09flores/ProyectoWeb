
package com.ProyectoWeb.controller;

import com.ProyectoWeb.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comentarios")

public class ComentarioController {

    @Autowired
    ComentarioService comentarioService;

    @GetMapping("/mostrar")
    public String page(Model model) {
        var comentarios = comentarioService.getComentarios(true);
        model.addAttribute("comentarios", comentarios);
        model.addAttribute("TotalComentarios", comentarios.size());

        return "/comentarios/mostrar";

    }

}
