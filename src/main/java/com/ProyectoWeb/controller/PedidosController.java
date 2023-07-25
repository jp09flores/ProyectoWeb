package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Categoria;
import com.ProyectoWeb.domain.DetallePedido;
import com.ProyectoWeb.domain.Pedido;
import com.ProyectoWeb.domain.Producto;
import com.ProyectoWeb.service.CategoriaService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pedidos")
@Slf4j
public class PedidosController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private DetallePedidoService detallePedidoService;

    @RequestMapping("/inicio")
    public String page(Model model) {
        Pedido pedido = pedidoService.obtenerUltimoPedido();
        model.addAttribute("pedido", pedido);
        List<Pedido> pedidos= pedidoService.getPedidos(true);
        model.addAttribute("pedidos", pedidos);
        return "/pedidos/inicio";
    }

    @PostMapping("/guardar")
    public String pedidoGuardar(Pedido pedido) {
        pedidoService.save(pedido);
        return "redirect:/pedidos/listado";
    }

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var productos = productoService.getProductos(true);
        var categorias = categoriaService.getCategorias(false);
        Pedido pedido = pedidoService.obtenerUltimoPedido();
        model.addAttribute("pedido", pedido);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pedidos/listado";
    }

    @GetMapping("/listado/{idCategoria}")
    public String listado(Model model, Categoria categoria) {
        var productos = categoriaService.getCategoria(categoria).getProductos();
        var categorias = categoriaService.getCategorias(false);
        Pedido pedido = pedidoService.obtenerUltimoPedido();
        model.addAttribute("pedido", pedido);
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos", productos.size());
        model.addAttribute("categorias", categorias);
        return "/pedidos/listado";
    }

    @RequestMapping("/editar")
    public String editarDetallePedido(Model model, Pedido pedido) {
        List<DetallePedido> detallePedidos = detallePedidoService.UltimoDetalleXPedido();
        List<Producto> productos = productoService.getProductos(true);
        List<Pedido> pedidos = pedidoService.getPedidos(true);
        model.addAttribute("detallePedidos", detallePedidos);
        model.addAttribute("TotalDetallePedidos", detallePedidos.size());
        model.addAttribute("productos", productos);
        model.addAttribute("pedidos", pedidos);
        return "/pedidos/editar";
    }

}
