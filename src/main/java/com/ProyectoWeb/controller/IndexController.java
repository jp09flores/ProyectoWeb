/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.ProyectoWeb.controller;

import com.ProyectoWeb.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jp09f
 */
@Controller
public class IndexController {

    @Autowired
    ComentarioService comentarioService;

    @RequestMapping("/")
    public String page(Model model) {
        var comentarios = comentarioService.PrimerosTresComentarios();
        model.addAttribute("comentarios", comentarios);
        return "index";
    }

}
