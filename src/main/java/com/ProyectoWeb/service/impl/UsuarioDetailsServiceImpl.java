package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.UsuarioDao;
import com.ProyectoWeb.domain.Rol;
import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //BUSCA EL CORREO EN LA BASE DE DATOS
        Usuario usuario = usuarioDao.findByUsername(username);
        
        //SI EL CORREO NO EXISTE EN LA BASE DE DATOS LANZA UNA EXCEPCION
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());

        var roles = new ArrayList<GrantedAuthority>();

        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre_rol()));
        }

        //necesitamos retornar un objeto de tipo "User" con los datos que necesitamos
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
}
