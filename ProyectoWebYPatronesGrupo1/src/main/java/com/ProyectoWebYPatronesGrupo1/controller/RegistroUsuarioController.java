
package com.ProyectoWebYPatronesGrupo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistroUsuarioController {
    
    @RequestMapping("/Usuario")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "/Usuario/RegistroUsuarios"; 
    }
}

