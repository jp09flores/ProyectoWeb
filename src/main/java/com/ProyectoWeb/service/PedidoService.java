/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Pedido;
import java.util.List;

public interface PedidoService {

    public List<Pedido> getPedidos(boolean activos);

    public Pedido getPedido(Pedido pedido);

    public void save(Pedido pedido);
}
