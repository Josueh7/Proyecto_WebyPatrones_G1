package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.Calorias;
import com.ProyectoWebYPatronesGrupo1.service.CaloriasService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calorias")
public class CaloriasController {

    @Autowired
    private CaloriasService caloriasService;

    @GetMapping("/regCalorias")
    public String regCalorias(Model model) {
        model.addAttribute("calorias", new Calorias());
        return "calorias/registrarCalorias";
    }

    @PostMapping("/guardar")
    public String registrarCaloria(Calorias caloria) {
        
        LocalDate fechaActual = LocalDate.now(); 
        
        caloria.setFecha(fechaActual.format(DateTimeFormatter.ISO_DATE));
        
        caloriasService.save(caloria);

        return "redirect:/calorias/listaCalorias";
    }

    @GetMapping("/listaCalorias")
    public String listaCalorias(Model model) {
        var calorias = caloriasService.getRegCalorias();
        model.addAttribute("calorias", calorias);
        return "calorias/listadoCalorias";
    }

    @GetMapping("/modificarCalorias/{idCalorias}")
    public String caloriaModificar(@ModelAttribute Calorias caloria, Model model) {
        caloria = caloriasService.getRegCaloria(caloria);
        model.addAttribute("caloria", caloria);
        return "calorias/modificarCalorias";
    }

    @GetMapping("/confirmarEliminar/{idCalorias}")
    public String caloriaConfirmEliminar(Calorias caloria, Model model) {
        caloria = caloriasService.getRegCaloria(caloria);
        model.addAttribute("caloria", caloria);
        return "/calorias/confirmarEliminarCalorias";
    }

    @GetMapping("/eliminar/{idCalorias}")
    public String caloriaEliminar(Calorias caloria) {
        caloriasService.delete(caloria);
        return "redirect:/calorias/listaCalorias";
    }
}


