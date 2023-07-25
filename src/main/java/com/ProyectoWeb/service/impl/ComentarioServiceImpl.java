
package com.ProyectoWeb.service.impl;

import com.ProyectoWeb.dao.ComentarioDao;
import com.ProyectoWeb.domain.Comentario;
import com.ProyectoWeb.service.ComentarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioServiceImpl implements ComentarioService{
    
    @Autowired
    ComentarioDao comentarioDao;

    @Override
    public List<Comentario> getComentarios(boolean estado) {
       List<Comentario>comentarios=comentarioDao.findAll();
       if(estado){
          comentarios.removeIf(r -> !r.isEstado());
       }
       return comentarios;
    }

    @Override
    public Comentario getComentario(Comentario comentario) {
    return comentarioDao.findById(comentario.getIdComentario()).orElse(null);
    }

    @Override
    public void save(Comentario comentario) {
        
       comentarioDao.save(comentario);
    }

    @Override
    public void delete(Comentario comentario) {
      comentarioDao.delete(comentario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comentario> PrimerosTresComentarios() {
         return comentarioDao.TraerSolo3Datos();
    }
  
}
