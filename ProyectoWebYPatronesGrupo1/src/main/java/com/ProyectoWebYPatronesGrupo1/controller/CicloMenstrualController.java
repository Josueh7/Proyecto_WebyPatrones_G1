/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.CicloMenstrual;
import com.ProyectoWebYPatronesGrupo1.service.CicloMenstrualService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @author danny
 */
@Controller
@RequestMapping("/cicloMenstrual")
public class CicloMenstrualController {

    @Autowired
    private CicloMenstrualService cicloService;

    @GetMapping("/regCiclo")
    public String regCiclo(Model model) {
        model.addAttribute("cicloMenstrual", new CicloMenstrual());
        return "cicloMenstrual/registrarCiclo";
    }
    
    
    
    @PostMapping("/guardar")
    public String registrarCiclo(CicloMenstrual ciclo, 
            @RequestParam(name = "dolorDeCabeza", defaultValue = "false") boolean dolorDeCabeza,
            @RequestParam(name = "cambiosEnLaPiel", defaultValue = "false") boolean cambiosEnLaPiel,
            @RequestParam(name = "nauseas", defaultValue = "false") boolean nauseas,
            @RequestParam(name = "vomitos", defaultValue = "false") boolean vomitos,
            @RequestParam(name = "dolorMenstrual", defaultValue = "false") boolean dolorMenstrual,
            @RequestParam(name = "otrosSintomas", defaultValue = "false") boolean otrosSintomas) {
        
        
        ciclo.setDolorDeCabeza(dolorDeCabeza);
        ciclo.setCambiosEnLaPiel(cambiosEnLaPiel);
        ciclo.setNauseas(nauseas);
        ciclo.setVomitos(vomitos);
        ciclo.setDolorMenstrual(dolorMenstrual);
        ciclo.setOtrosSintomas(otrosSintomas);
        cicloService.save(ciclo);
        
        return "redirect:/cicloMenstrual/listaCiclos";
    }
    
    @GetMapping("/listaCiclos")
    public String listaCiclos(Model model) {
        var ciclos = cicloService.getRegistrosCicloMenstrual();
        model.addAttribute("ciclos", ciclos);
        return "cicloMenstrual/listadoCiclo";
    }
    
    @GetMapping("/modificarCiclo/{idRegistro}")
    public String cicloModificar(@ModelAttribute CicloMenstrual ciclo, Model model) {
        ciclo = cicloService.getCicloMenstrual(ciclo);
        model.addAttribute("ciclo", ciclo);
        return "cicloMenstrual/modificarCiclo";
    }
    
    @GetMapping("/confirmarEliminar/{idRegistro}")
    public String cicloMenstrualConfirmEliminar(CicloMenstrual ciclo, Model model){
        ciclo = cicloService.getCicloMenstrual(ciclo);
        model.addAttribute("ciclo", ciclo);
        return "/cicloMenstrual/confirmarEliminarCiclo";
    }
    
    @GetMapping("/eliminar/{idRegistro}")
    public String cicloMenstrualEliminar(CicloMenstrual ciclo){
        cicloService.delete(ciclo);
        return "redirect:/cicloMenstrual/listaCiclos";
    }
}

