
package com.ProyectoWeb.service;
import com.ProyectoWeb.domain.Comentario;

import java.util.List;
public interface ComentarioService {
    
     public List<Comentario> getComentarios(boolean estado);

    public Comentario getComentario(Comentario comentario);

    public void save(Comentario comentario);
    
    public void delete(Comentario comentario);
    
}
