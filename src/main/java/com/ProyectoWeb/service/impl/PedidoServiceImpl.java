/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.service.impl;


import com.ProyectoWeb.dao.PedidoDao;
import com.ProyectoWeb.domain.Pedido;
import com.ProyectoWeb.service.PedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoServiceImpl implements PedidoService{
    
    @Autowired
    PedidoDao pedidoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> getPedidos(boolean activos) {
        List<Pedido> pedidos = pedidoDao.findAll();
        
        if(activos){
            pedidos.removeIf(x -> !x.isEstado());
        }
        
        return pedidos;
    }

    @Override
    @Transactional(readOnly = true)
    public Pedido getPedido(Pedido pedido) {
        return pedidoDao.findById(pedido.getIdPedido()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Pedido pedido) {
        pedidoDao.save(pedido);
    }

    
}
