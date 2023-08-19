/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.UsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jp09f
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @RequestMapping("/usuarios/listado")
    public String page(Model model) {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "admin/listado";
    }
    
    
    @RequestMapping("/usuarios/modificar/{idUsuario}")
    public String modificar(Model model,Usuario usuario) {
       usuario = usuarioService.getUsuario(usuario);
       model.addAttribute("usuario", usuario);
        return "admin/modificar";
    }
    
    @PostMapping("/usuarios/guardar")
    public String guardar(Usuario usuario) {
       if (usuario.getIdUsuario() != null && usuario.getIdUsuario() > 0) {
            var temp = usuarioService.getUsuario(usuario);
            usuario.setIdUsuario(temp.getIdUsuario());
            usuario.setPassword(temp.getPassword());
            usuario.setUsername(temp.getUsername());
            usuario.setRoles(temp.getRoles());
        } else {
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        }
        
        if (usuario.getRoles() == null) {
            usuarioService.save(usuario, true);
        } else {
            usuarioService.save(usuario, false);
        }
        return "admin/listado";
    }
    
    
}
