package com.ProyectoWeb.controller;

import com.ProyectoWeb.dao.UsuarioDao;
import com.ProyectoWeb.domain.Factura;
import com.ProyectoWeb.domain.Pedido;
import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.DetallePedidoService;
import com.ProyectoWeb.service.FacturaService;
import com.ProyectoWeb.service.PedidoService;
import com.ProyectoWeb.service.ProductoService;
import com.ProyectoWeb.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
@Slf4j
public class PerfilController {
    
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

    @Autowired
    UsuarioService usuarioService;



    @RequestMapping("/mostrar")
    public String PageMostrar(Model model, HttpSession httpSession) {
        model.addAttribute("idUsuario", httpSession.getAttribute("IdUsuario"));
        model.addAttribute("Usuario", httpSession.getAttribute("Usuario"));
        model.addAttribute("Nombre", httpSession.getAttribute("Nombre"));
        model.addAttribute("PriApellido", httpSession.getAttribute("PriApellido"));
        model.addAttribute("SegApellido", httpSession.getAttribute("SegApellido"));
        model.addAttribute("Correo", httpSession.getAttribute("Correo"));
        model.addAttribute("Telefono", httpSession.getAttribute("Telefono"));
        model.addAttribute("rutaImagen", httpSession.getAttribute("rutaImagen"));

        return "/perfil/mostrar";
    }

    @RequestMapping("/editar")
    public String PageEditar(Model model, HttpSession httpSession) {
        model.addAttribute("idUsuario", httpSession.getAttribute("IdUsuario"));
        model.addAttribute("Usuario", httpSession.getAttribute("Usuario"));
        model.addAttribute("Nombre", httpSession.getAttribute("Nombre"));
        model.addAttribute("PriApellido", httpSession.getAttribute("PriApellido"));
        model.addAttribute("SegApellido", httpSession.getAttribute("SegApellido"));
        model.addAttribute("Correo", httpSession.getAttribute("Correo"));
        model.addAttribute("Telefono", httpSession.getAttribute("Telefono"));
        model.addAttribute("rutaImagen", httpSession.getAttribute("rutaImagen"));
        model.addAttribute("password", httpSession.getAttribute("password"));
        return "/perfil/editar";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario) {
         if (usuario.getIdUsuario() != null && usuario.getIdUsuario() > 0) {
            var temp = usuarioService.getUsuario(usuario);
            usuario.setPassword(temp.getPassword());
            usuario.setUsername(temp.getUsername());
            usuario.setRoles(temp.getRoles());
        } else {
            usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        }
       
        usuarioDao.save(usuario);
        return "redirect:/perfil/mostrar";
    }

    @GetMapping("/historial/{idUsuario}")
    public String listado(Model model,Usuario usuario) {
        List<Factura> facturas = usuarioService.getUsuario(usuario).getFacturas();
        List<Usuario> usuarios = usuarioService.getUsuarios();
        List<Pedido> pedidos = pedidoService.getPedidos(true);
        model.addAttribute("facturas", facturas);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("pedidos", pedidos);
        return "perfil/historial";
    }
    
     @GetMapping("/listado/{idPedido}")
    public String listado(Model model, Pedido pedido,HttpSession httpSession) {
        model.addAttribute("idUsuario", httpSession.getAttribute("IdUsuario"));
        var detallePedidos = pedidoService.getPedido(pedido).getDetallePedidos();
        var pedidos = pedidoService.getPedidos(false);
        model.addAttribute("detallePedidos", detallePedidos);
        model.addAttribute("TotalDetalle", detallePedidos.size());
        model.addAttribute("pedidos", pedidos);
        return "/perfil/listado";
    }
}
