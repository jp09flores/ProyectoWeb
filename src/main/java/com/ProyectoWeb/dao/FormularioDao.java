
package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FormularioDao extends JpaRepository<Formulario, Long>{
    // mas adelante vamos a crear metodos ampliados
}
