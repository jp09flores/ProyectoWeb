/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PedidoDao extends JpaRepository<Pedido, Long>{
    
     @Query(nativeQuery=true,
            value="SELECT * FROM proyectoweb.pedido ORDER BY id_pedido DESC LIMIT 1")
    public Pedido TraerUltimoDatoPedido(); 
}
