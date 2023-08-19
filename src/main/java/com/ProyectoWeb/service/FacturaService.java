/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Factura;
import java.util.List;

/**
 *
 * @author jp09f
 */
public interface FacturaService {
    
    public List<Factura> getFacturas(boolean activos);

    public Factura getFactura(Factura factura);

    public void save(Factura factura);
    
    public int total();
}
