/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.Sueno;
import com.ProyectoWebYPatronesGrupo1.service.SuenoService;
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
    
    @PostMapping("/registrar")
    public String registrarSueno(Sueno sueno, RedirectAttributes redirectAttributes) {
        
        sueno.setFecha(sueno.getMomentoInicio().format(DateTimeFormatter.ISO_DATE));
        
        Duration duracion = Duration.between(sueno.getMomentoInicio(), sueno.getMomentoFinal());
        
        long diferenciaHoras = duracion.toHours();
        sueno.setCantHoraSueno((int)diferenciaHoras);

        // Guarda el sueño en la base de datos
        suenoService.save(sueno);
        
        redirectAttributes.addFlashAttribute("guardadoExitoso", "Registro guardado con éxito");
        
        return "redirect:/sueno/regSueno";
    }
    
     @GetMapping("/listaSuenos")
    public String listaSuenos(Model model) {
        var suenos = suenoService.getInfoRegSuenos();
        model.addAttribute("suenos", suenos);
        return "sueno/listadoSueno";
    }
}

