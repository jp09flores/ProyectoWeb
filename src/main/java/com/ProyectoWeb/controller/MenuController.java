/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.ProyectoWeb.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author jp09f
 */
@Controller
@RequestMapping("/menu")
@Slf4j
public class MenuController {
    
     @RequestMapping("/listado")
    public String page(Model model) {
        return "/menu/listado";
    }
    
//      @Autowired
//    private ProductoService productoService;
//    @Autowired
//    private CategoriaService categoriaService;
//
//    @GetMapping("/listado")
//    public String listado(Model model) {
//        var productos = productoService.getProductos(false);
//        var categorias = categoriaService.getCategorias(false);
//        model.addAttribute("productos", productos);
//        model.addAttribute("totalProductos", productos.size());
//        model.addAttribute("categorias", categorias);
//        return "/pruebas/listado";
//    }
//
//    @GetMapping("/listado/{idCategoria}")
//    public String listado(Model model, Categoria categoria) {
//        var productos = categoriaService.getCategoria(categoria).getProductos();
//        var categorias = categoriaService.getCategorias(false);
//        model.addAttribute("productos", productos);
//        model.addAttribute("totalProductos", productos.size());
//        model.addAttribute("categorias", categorias);
//        return "/pruebas/listado";
//    }
//    
//     @PostMapping("/guardar")
//    public String productoaGuardar(Producto producto,
//            @RequestParam("imagenFile") MultipartFile imagenFile) {
//        if (!imagenFile.isEmpty()) {
//            productoService.save(producto);
//            producto.setRutaImagen(
//                    firebaseStorageService.cargaImagen(
//                            imagenFile,
//                            "producto",
//                            producto.getIdProducto()));
//        }
//        productoService.save(producto);
//        return "redirect:/producto/listado";
//    }
//
//    @GetMapping("/eliminar/{idProducto}")
//    public String productoEliminar(Producto producto) {
//        productoService.delete(producto);
//        return "redirect:/producto/listado";
//    }
//
//    @GetMapping("/modificar/{idProducto}")
//    public String productoModificar(Producto producto, Model model) {
//        producto = productoService.getProducto(producto);
//        List<Categoria> categorias = categoriaService.getCategorias(true);
//        model.addAttribute("producto", producto);
//        model.addAttribute("categorias", categorias);
//        return "/producto/modifica";
//    }
//    
}
