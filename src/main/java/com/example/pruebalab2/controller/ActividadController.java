package com.example.pruebalab2.controller;


import com.example.pruebalab2.entity.Actividad;
import com.example.pruebalab2.entity.AreaEntity;
import com.example.pruebalab2.entity.Proyecto;
import com.example.pruebalab2.entity.UsuarioEntity;
import com.example.pruebalab2.repository.ActividadRepository;
import com.example.pruebalab2.repository.ProyectoRepository;
import com.example.pruebalab2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/actividad")
public class ActividadController {

    @Autowired
    ActividadRepository actividadRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProyectoRepository proyectoRepository;

    @GetMapping("/newformActividad")
    public String newform(@RequestParam("idproyecto") int idproyecto,@RequestParam("usuario_owner") String correo, Model model){
        model.addAttribute("usuario_owner",correo);
        model.addAttribute("idproyecto",idproyecto);
        return "actividad/newformActividad";
    }

    @PostMapping("/save")
    public String saveactividad(@RequestParam("id") int id, Actividad actividad, RedirectAttributes attr){
        actividadRepository.save(actividad);
        attr.addFlashAttribute("msg","Actividad editada Exitosamente");
        return "redirect:/proyecto/editar?id=" + id;
    }

    @GetMapping("/editar")
    public String editarActividad(@RequestParam("id") int id, Model model){
        Optional<Actividad> optionalActividad = actividadRepository.findById(id);
        if (optionalActividad.isPresent()) {
            Actividad actividad = optionalActividad.get();
            model.addAttribute("actividad", actividad);
            return "actividad/editActividad";
        } else {
            return "redirect:/proyecto/editar?id=" + id;
        }

    }

    @PostMapping("/edit")
    public String editActividad(Actividad actividad, @RequestParam("id") int id){
        actividadRepository.save(actividad);
        return "redirect:/proyecto/editar?id=" + id;
    }
}
