/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.Sueno;
import com.ProyectoWebYPatronesGrupo1.service.SuenoService;
import static java.rmi.server.LogStream.log;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author danny
 */
@Controller
@RequestMapping("/sueno")
public class SuenoController {

//    @Autowired
//    private SuenoService suenoService;
    @Autowired
    private SuenoService suenoService;

    @GetMapping("/regSueno")
    public String regSueno(Model model) {
        model.addAttribute("sueno", new Sueno());
        return "sueno/registrarSueno";
    }
    
    
    
    @PostMapping("/guardar")
    public String registrarSueno(Sueno sueno) {
        
        
        sueno.setFecha(sueno.getMomentoInicio().format(DateTimeFormatter.ISO_DATE));
        
        Duration duracion = Duration.between(sueno.getMomentoInicio(), sueno.getMomentoFinal());
        
        long diferenciaHoras = duracion.toHours();
        sueno.setCantHoraSueno((int)diferenciaHoras);

        suenoService.save(sueno);
        
        return "redirect:/sueno/listaSuenos";
    }
    
    @GetMapping("/listaSuenos")
    public String listaSuenos(Model model) {
        var suenos = suenoService.getInfoRegSuenos();
        model.addAttribute("suenos", suenos);
        return "sueno/listadoSueno";
    }
    
    @GetMapping("/modificarSueno/{idSueno}")
    public String suenoModificar(@ModelAttribute Sueno sueno, Model model) {
        sueno = suenoService.getRegSueno(sueno);
        model.addAttribute("sueno", sueno);
        return "sueno/modificarSueno";
    }
    
    @GetMapping("/confirmarEliminar/{idSueno}")
    public String suenoConfirmEliminar(Sueno sueno, Model model){
        sueno = suenoService.getRegSueno(sueno);
        model.addAttribute("sueno", sueno);
        return "/sueno/confirmarEliminarSueno";
    }
    
    @GetMapping("/eliminar/{idSueno}")
    public String suenoEliminar(Sueno sueno){
        suenoService.delete(sueno);
        return "redirect:/sueno/listaSuenos";
    }
}

