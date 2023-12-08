
package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.Peso;
import com.ProyectoWebYPatronesGrupo1.service.PesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/peso")
public class PesoController {

     @Autowired
    private PesoService pesoService;

    @GetMapping("/regPeso")
    public String regPeso(Model model) {
        model.addAttribute("peso", new Peso());
        return "peso/registrarPeso";
    }
    
    
    
    @PostMapping("/guardar")
    public String registrarPeso(Peso peso) {

        pesoService.save(peso);
        
        return "redirect:/peso/listaPesos";
    }
    
    @GetMapping("/listaPesos")
    public String listaPesos(Model model) {
        var pesos = pesoService.getPesos();
        model.addAttribute("pesos", pesos);
        return "peso/listadoPeso";
    }
    
    @GetMapping("/modificarPeso/{idPeso}")
    public String pesoModificar(Peso peso, Model model) {
        peso = pesoService.getPeso(peso);
        model.addAttribute("peso", peso);
        return "peso/modificarPeso";
    }
    
    @GetMapping("/confirmarEliminar/{idPeso}")
    public String pesoConfirmEliminar(Peso peso, Model model){
        peso = pesoService.getPeso(peso);
        model.addAttribute("peso", peso);
        return "/peso/confirmarEliminarPeso";
    }
    
    @GetMapping("/eliminar/{idPeso}")
    public String pesoEliminar(Peso peso){
        pesoService.delete(peso);
        return "redirect:/peso/listaPesos";
    }
    
}
