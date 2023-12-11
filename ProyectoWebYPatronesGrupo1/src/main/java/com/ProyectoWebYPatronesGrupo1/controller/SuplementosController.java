package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.Suplementos;
import com.ProyectoWebYPatronesGrupo1.service.SuplementosService;
import java.time.LocalDate;
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
 * @author josep
 */
@Controller
@RequestMapping("/Suplementos")
public class SuplementosController {

    @Autowired
    private SuplementosService suplementosService;

    @GetMapping("/regSuplementos")
    public String regSuplementos(Model model) {
        model.addAttribute("suplementos", new Suplementos());
        return "Suplementos/registrarSuplementos";
    }

    @PostMapping("/guardar")
    public String registrarCiclo(Suplementos suplementos,
            @RequestParam(name = "proteina", defaultValue = "false") boolean proteina,
            @RequestParam(name = "creatina", defaultValue = "false") boolean creatina,
            @RequestParam(name = "aminoacidos", defaultValue = "false") boolean aminoacidos,
            @RequestParam(name = "multivitaminicos", defaultValue = "false") boolean multivitaminicos,
            @RequestParam(name = "preEntreno", defaultValue = "false") boolean preEntreno,
            @RequestParam(name = "otrosSuplementos", defaultValue = "false") boolean otrosSuplementos) {

        suplementos.setProteina(proteina);
        suplementos.setAminoacidos(aminoacidos);
        suplementos.setCreatina(creatina);
        suplementos.setMultivitaminicos(multivitaminicos);
        suplementos.setPreEntreno(preEntreno);
        suplementos.setOtrosSuplementos(otrosSuplementos);
        LocalDate fechaActual = LocalDate.now();
        suplementos.setFecha(fechaActual.format(DateTimeFormatter.ISO_DATE));
        suplementosService.save(suplementos);

        return "redirect:/Suplementos/listadoSuplementos";
    }

    @GetMapping("/listadoSuplementos")
    public String listaSuplementos(Model model) {
        var suplementos = suplementosService.getRegistrosSuplementos();
        model.addAttribute("suplementos", suplementos);
        var topTres = suplementosService.calcularTopTres(suplementos);
        model.addAttribute("topTres", topTres);
        return "Suplementos/listadoSuplementos";
    }

    @GetMapping("/modificarSuplementos/{idRegistro}")
    public String suplementosModificar(@ModelAttribute Suplementos suplementos, Model model) {
        suplementos = suplementosService.getSuplementos(suplementos);
        model.addAttribute("suplementos", suplementos);
        return "Suplementos/modificarSuplementos";
    }

    @GetMapping("/confirmarEliminar/{idRegistro}")
    public String suplementosConfirmEliminar(Suplementos suplementos, Model model) {
        suplementos = suplementosService.getSuplementos(suplementos);
        model.addAttribute("suplementos", suplementos);
        return "/Suplementos/confirmarEliminarSuplementos";
    }

    @GetMapping("/eliminar/{idRegistro}")
    public String suplementosEliminar(Suplementos suplementos) {
        suplementosService.delete(suplementos);
        return "redirect:/Suplementos/listadoSuplementos";
    }

}

