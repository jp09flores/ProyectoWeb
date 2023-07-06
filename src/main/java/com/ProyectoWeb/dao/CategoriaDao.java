/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.dao;




import com.ProyectoWeb.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jp09f
 */
public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    
}
