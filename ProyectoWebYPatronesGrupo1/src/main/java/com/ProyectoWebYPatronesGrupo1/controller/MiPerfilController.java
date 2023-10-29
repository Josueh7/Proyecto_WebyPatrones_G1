package com.ProyectoWebYPatronesGrupo1.controller;

import com.ProyectoWebYPatronesGrupo1.domain.MiPerfil;
import com.ProyectoWebYPatronesGrupo1.service.MiPerfilService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perfil")
public class MiPerfilController {

    @Autowired
    private MiPerfilService perfilService;

    @GetMapping("/MiPerfil")
    public String inicio(Model model) {

        List<MiPerfil> informacionPerfil = perfilService.getInfoPerfil();
        model.addAttribute("informacion", informacionPerfil);//para la vista mando desde el controlador con el model todas las categorias

        return "/perfil/MiPerfil";
    }

    @GetMapping("/nuevo")
    public String Nuevo(MiPerfil perfil) {
        return "/perfil/modifica";
    }
    
    @PostMapping("/guardar")
    public String categoriaGuardar(MiPerfil perfil) {
        perfilService.save(perfil);
        return "redirect:/perfil/MiPerfil";
    }
    
        @GetMapping("/eliminar/{idUsuario}")
    public String categoriaEliminar(MiPerfil perfil) {
        perfilService.delete(perfil);
        return "redirect:/perfil/MiPerfil";
    }

    @GetMapping("/modificar/{idUsuario}")
    public String categoriaModificar(MiPerfil perfil, Model model) {
        perfil = perfilService.getCampoPerfil(perfil);
        model.addAttribute("perfil", perfil);
        return "/perfil/modifica";
    }

}
