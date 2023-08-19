package com.ProyectoWeb.controller;

import com.ProyectoWeb.dao.UsuarioDao;
import com.ProyectoWeb.domain.DetallePedido;
import com.ProyectoWeb.domain.Factura;
import com.ProyectoWeb.domain.Pedido;
import com.ProyectoWeb.domain.Producto;
import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.DetallePedidoService;
import com.ProyectoWeb.service.FacturaService;
import com.ProyectoWeb.service.PedidoService;
import com.ProyectoWeb.service.ProductoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @Autowired
    private FacturaService facturaService;
    
    
     @Autowired
    UsuarioDao usuarioDao;

    @GetMapping("/agregar/{idProducto}")
    public String agregarProducto(Producto producto, Model model) {
        Pedido pedido = pedidoService.obtenerUltimoPedido();
        producto = productoService.getProducto(producto);
        model.addAttribute("pedido", pedido);
        model.addAttribute("producto", producto);
        return "/detallePedido/agregar";
    }

    @PostMapping("/agregar/guardar")
    public String DetallePedidoGuardar(DetallePedido detallePedido) {
        detallePedidoService.save(detallePedido);
        return "redirect:/pedidos/listado";
    }

    @PostMapping("/agregar/guardar2")
    public String DetallePedidoGuardar2(DetallePedido detallePedido) {
        detallePedidoService.save(detallePedido);
        return "redirect:/detallePedido/listado";
    }

    @GetMapping("/listado")
    public String page(Model model,HttpSession httpSession) {
        
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        UserDetails user = null;
        
        if(principal instanceof UserDetails){
            user = (UserDetails) principal;
        }
        
        if(user!=null){
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            
            httpSession.setAttribute("IdUsuario", usuario.getIdUsuario());
            
        }
        
        List<DetallePedido> detallePedidos = detallePedidoService.UltimoDetalleXPedido();
        List<Producto> productos = productoService.getProductos(true);
        model.addAttribute("detallePedidos", detallePedidos);
        model.addAttribute("TotalDetallePedidos", detallePedidos.size());
        model.addAttribute("productos", productos);
        
        return "/detallePedido/listado";
    }

    @GetMapping("/eliminar/{cont}")
    public String detallePedidoEliminar(DetallePedido detallePedido) {
        detallePedidoService.delete(detallePedido);
        return "redirect:/detallePedido/listado";
    }

    @GetMapping("/editar/{cont}")
    public String productoModificar(DetallePedido detallePedido, Model model) {
        detallePedido = detallePedidoService.getDetallePedido(detallePedido);
        List<Producto> producto = productoService.getProductos(true);
        List<Pedido> pedido = pedidoService.getPedidos(true);
        model.addAttribute("detallePedido", detallePedido);
        model.addAttribute("producto", producto);
        model.addAttribute("pedido", pedido);
        return "/detallePedido/editar";
    }
    
    @RequestMapping("/confirmar")
    public String confirmar(Model model,HttpSession httpSession) {
        int total = facturaService.total();
        Pedido pedido = pedidoService.obtenerUltimoPedido();
        model.addAttribute("pedido", pedido);
        model.addAttribute("total", total);
        model.addAttribute("idUsuario", httpSession.getAttribute("IdUsuario"));
        return "detallePedido/confirmar";
    }
    @RequestMapping("/confirmar/guardar")
    public String guardarFactura(Factura factura) {
        facturaService.save(factura);
        return "redirect:/";
    }
}
