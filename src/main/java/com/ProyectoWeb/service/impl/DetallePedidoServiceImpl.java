/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.service.impl;


import com.ProyectoWeb.dao.DetallePedidoDao;
import com.ProyectoWeb.domain.DetallePedido;
import com.ProyectoWeb.service.DetallePedidoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
    
    @Autowired
    DetallePedidoDao detallePedidoDao;

    @Override
    @Transactional(readOnly = true)
    public List<DetallePedido> getDetallePedidos(boolean estado) {
        List<DetallePedido> detallePedidos = detallePedidoDao.findAll();
        
        if(estado){
            detallePedidos.removeIf(x -> !x.isEstado());
        }
        
        return detallePedidos;
    }

    @Override
    @Transactional(readOnly = true)
    public DetallePedido getDetallePedido(DetallePedido detallePedido) {
        return detallePedidoDao.findById(detallePedido.getCont()).orElse(null);
    }

    @Override
    @Transactional
    public void save(DetallePedido detallePedido) {
        detallePedidoDao.save(detallePedido);
    }

    @Override
    public void delete(DetallePedido detallePedido) {
          detallePedidoDao.delete(detallePedido);
    }

    
}
