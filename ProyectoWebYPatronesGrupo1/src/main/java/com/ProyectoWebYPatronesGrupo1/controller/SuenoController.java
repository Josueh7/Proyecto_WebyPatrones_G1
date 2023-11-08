/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.Sueno;
import com.ProyectoWebYPatronesGrupo1.service.SuenoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author danny
 */
@Controller
@RequestMapping("/sueno")
public class SuenoController {

//    @Autowired
//    private SuenoService suenoService;

    @GetMapping("/RegSueno")
    public String inicio(Model model) {


        return "sueno/fragmentoSueno";
    }
}

