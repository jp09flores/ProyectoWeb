/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Categoria;
import java.util.List;

/**
 *
 * @author jp09f
 */
public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);

    public Categoria getCategoria(Categoria categoria);

    public void save(Categoria categoria);
}
