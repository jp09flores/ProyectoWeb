/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.DetallePedido;
import java.util.List;

public interface DetallePedidoService {

    public List<DetallePedido> getDetallePedidos(boolean estado);

    public DetallePedido getDetallePedido(DetallePedido detallePedido);

    public void save(DetallePedido detallePedido);
    
    
    public void delete(DetallePedido detallePedido);
    
    public List<DetallePedido> UltimoDetalleXPedido();
}
