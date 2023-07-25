/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.dao;
import com.ProyectoWeb.domain.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComentarioDao extends JpaRepository<Comentario, Long>{
    
    @Query(nativeQuery=true,
            value="select * from proyectoweb.comentarios limit 3")
    public List<Comentario> TraerSolo3Datos(); 
}
