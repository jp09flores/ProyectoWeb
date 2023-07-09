package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.DetallePedido;
import com.ProyectoWeb.domain.Pedido;
import com.ProyectoWeb.domain.Producto;
import com.ProyectoWeb.service.DetallePedidoService;
import com.ProyectoWeb.service.PedidoService;
import com.ProyectoWeb.service.ProductoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detallePedido")
@Slf4j
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/agregar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/detallePedido/agregar";
    }

    @PostMapping("/agregar/guardar")
    public String DetallePedidoGuardar(DetallePedido detallePedido) {
        detallePedidoService.save(detallePedido);
        return "redirect:/pedidos/listado";
    }
     
    
    @GetMapping("/listado")                             //Solo mediante peticiones GET
    public String page(Model model) {
        List<DetallePedido> detallePedidos = detallePedidoService.getDetallePedidos(true);
        List<Producto> productos = productoService.getProductos(true);
        List<Pedido> pedidos = pedidoService.getPedidos(true);
        model.addAttribute("detallePedidos", detallePedidos);
        model.addAttribute("productos", productos);
        model.addAttribute("pedidos", pedidos);
        return "/detallePedido/listado";
    }
    
    
}
