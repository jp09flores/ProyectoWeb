
package com.ProyectoWeb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nosotros")
@Slf4j
public class NosotrosController {
    
    @RequestMapping("/muestra")
    public String page(Model model) {
         return"/nosotros/muestra";
    }
    
}
