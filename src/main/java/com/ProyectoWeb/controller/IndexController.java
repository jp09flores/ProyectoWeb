/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.ProyectoWeb.controller;

import com.ProyectoWeb.dao.UsuarioDao;
import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.ComentarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    ComentarioService comentarioService;

    
    @Autowired
    UsuarioDao usuarioDao;
    
    @RequestMapping("/")
    public String page(Model model, HttpSession httpSession) {
        var comentarios = comentarioService.PrimerosTresComentarios();
        model.addAttribute("comentarios", comentarios);
         
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        UserDetails user = null;
        
        if(principal instanceof UserDetails){
            user = (UserDetails) principal;
        }
        
        if(user!=null){
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            
            httpSession.setAttribute("IdUsuario", usuario.getIdUsuario());
            httpSession.setAttribute("Usuario", usuario.getUsername());
            httpSession.setAttribute("Nombre", usuario.getNombreUsuario());
            httpSession.setAttribute("PriApellido", usuario.getPrimerApellido());
            httpSession.setAttribute("SegApellido", usuario.getSegundoApellido());
            httpSession.setAttribute("Correo", usuario.getCorreo());
            httpSession.setAttribute("Telefono", usuario.getTelefono());
            httpSession.setAttribute("rutaImagen", usuario.getRutaImagen());
            httpSession.setAttribute("password", usuario.getPassword());
            
        }
        
        
        
        
        return "index";
    }

}
