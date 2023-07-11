package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.UsuarioDao;
import com.ProyectoWeb.domain.Rol;
import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.dto.UsuarioRegistroDTO;
import com.ProyectoWeb.service.UsuarioService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public Usuario save(UsuarioRegistroDTO registroDTO) {
          Usuario usuario = new Usuario(registroDTO.getNombreUsuario(),
                registroDTO.getPrimer_apellido(),
                registroDTO.getSegundo_apellido(),
                registroDTO.getEmail(),
                registroDTO.getPass(),
                Arrays.asList(new Rol("USER_ROL")));
        return usuarioDao.save(usuario);
    }

}
