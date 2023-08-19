/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWeb.service.impl;


import com.ProyectoWeb.dao.FacturaDao;
import com.ProyectoWeb.domain.Factura;
import com.ProyectoWeb.service.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaServiceImpl implements FacturaService{
    
    @Autowired
    FacturaDao facturaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> getFacturas(boolean activos) {
        List<Factura> facturas = facturaDao.findAll();
        
        if(activos){
            facturas.removeIf(x -> !x.isEstado());
        }
        
        return facturas;
    }

    @Override
    @Transactional(readOnly = true)
    public Factura getFactura(Factura factura) {
        return facturaDao.findById(factura.getIdFactura()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Factura factura) {
        facturaDao.save(factura);
    }

    @Override
    public int total() {
       return  facturaDao.Total();
    }
    
  
    
}
