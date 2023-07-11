
package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Usuario;
import com.ProyectoWeb.dto.UsuarioRegistroDTO;

public interface UsuarioService {

    public Usuario save(UsuarioRegistroDTO registroDTO);
}
