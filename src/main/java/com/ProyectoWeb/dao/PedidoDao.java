/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoDao extends JpaRepository<Pedido, Long>{
    // mas adelante vamos a crear metodos ampliados
}
