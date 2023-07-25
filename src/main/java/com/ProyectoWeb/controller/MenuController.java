/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Categoria;
import com.ProyectoWeb.domain.DetallePedido;
import com.ProyectoWeb.domain.Pedido;
import com.ProyectoWeb.domain.Producto;
import com.ProyectoWeb.service.CategoriaService;
import com.ProyectoWeb.service.ProductoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jp09f
 */
@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(true);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/menu/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/menu/listado";
    }

    @PostMapping("/guardar")
    public String productoGuardar(Producto producto) {
        productoService.save(producto);
        return "redirect:/menu/listado";
    }

    @GetMapping("/editar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        return "/menu/editar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        List<Categoria> categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/menu/agregar";
    }
}
