package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Factura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacturaDao extends JpaRepository<Factura, Long> {

    @Query(nativeQuery = true,
            value = "SELECT\n"
            +"    SUM(dp.cantidad_producto * pr.precio) AS total_pedido\n"
            + "FROM\n"
            + "    ProyectoWeb.detalle_pedido dp\n"
            + "JOIN\n"
            + "    ProyectoWeb.producto pr ON dp.id_producto = pr.id_producto\n"
            + "WHERE\n"
            + "     id_pedido = (SELECT MAX(id_pedido)FROM ProyectoWeb.pedido);")
    public int Total();
}
