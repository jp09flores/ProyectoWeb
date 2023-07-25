
package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.DetallePedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetallePedidoDao extends JpaRepository<DetallePedido, Long>{
    
     @Query(nativeQuery=true,
            value="SELECT *FROM ProyectoWeb.detalle_pedido WHERE id_pedido = (SELECT MAX(id_pedido)FROM ProyectoWeb.pedido)")
    public List<DetallePedido> TraerDetallePedidosXUltimoPedido(); 
}
