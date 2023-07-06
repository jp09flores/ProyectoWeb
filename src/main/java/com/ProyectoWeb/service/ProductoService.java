/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Producto;
import java.util.List;

public interface ProductoService {

    public List<Producto> getProductos(boolean estado);

    public Producto getProducto(Producto producto);

    public void save(Producto producto);
}
