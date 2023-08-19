
package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Formulario;
import com.ProyectoWeb.service.FormularioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contactenos")
@Slf4j
public class ContactenosController {
    
    @RequestMapping("/muestra")
    public String page(Model model) {
        return"/contactenos/muestra";
    }
    
    @Autowired
    FormularioService formularioService;
    
    @PostMapping("/formulario/guardar")
    public String guardarFactura(Formulario formulario) {
        formularioService.save(formulario);
        return "redirect:/contactenos/muestra";
    }
    
}
