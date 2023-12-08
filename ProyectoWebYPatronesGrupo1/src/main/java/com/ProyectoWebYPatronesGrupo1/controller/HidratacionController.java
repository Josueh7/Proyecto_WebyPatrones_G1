/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.Hidratacion;
import com.ProyectoWebYPatronesGrupo1.service.HidratacionService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/hidratacion")
public class HidratacionController {


    @Autowired
    private HidratacionService hidratacionService;

    @GetMapping("/regHidratacion")
    public String regHidratacion(Model model) {
        model.addAttribute("hidratacion", new Hidratacion());
        return "hidratacion/registrarHidratacion";
    }
    
    
    
    @PostMapping("/guardar")
    public String registrarHidratacion(Hidratacion hidratacion) {
        
        LocalDate fechaActual = LocalDate.now(); 
        
        hidratacion.setFecha(fechaActual.format(DateTimeFormatter.ISO_DATE));
        
        hidratacionService.save(hidratacion);

        return "redirect:/hidratacion/listaHidratacion";
        
       
    }
    
    @GetMapping("/listaHidratacion")
    public String listaHidratacion(Model model) {
        var hidratacion = hidratacionService.getRegistrosHidratacion();
        model.addAttribute("hidratacion", hidratacion);
        return "hidratacion/listadoHidratacion";
       
    }

    @GetMapping("/modificarRegistro/{idHidratacion}")
    public String hidratacionModificar(Hidratacion hidratacion, Model model) {
        hidratacion = hidratacionService.getHidratacion(hidratacion);
        model.addAttribute("hidratacion", hidratacion);
        return "hidratacion/modificarHidratacion";
    }

    @GetMapping("/confirmarEliminar/{idHidratacion}")
    public String hidratacionConfirmarEliminar(Hidratacion hidratacion, Model model){
        hidratacion = hidratacionService.getHidratacion(hidratacion);
        model.addAttribute("hidratacion", hidratacion);
        return "/hidratacion/confirmarEliminarHidratacion";
    }

    @GetMapping("/eliminar/{idHidratacion}")
    public String hidratacionEliminar(Hidratacion hidratacion) {
        hidratacionService.delete(hidratacion);
        return "redirect:/hidratacion/listaHidratacion";
    }
}
