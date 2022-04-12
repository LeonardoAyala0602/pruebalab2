package com.example.pruebalab2.controller;


import com.example.pruebalab2.entity.Actividad;
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

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/proyecto")

public class ProyectoController {

    @Autowired
    ProyectoRepository proyectoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ActividadRepository actividadRepository;

    @GetMapping("/listar")
    public String listarProyecto(Model model){
        List<Proyecto> proyectoList = proyectoRepository.findAll();
        model.addAttribute("proyectoList", proyectoList);
        return "proyecto/lista";
    }

    @GetMapping("/newform")
    public String newform(Model model){
        List<UsuarioEntity> usuarioEntityList = usuarioRepository.findAll();
        model.addAttribute("usuarioEntityList",usuarioEntityList);
        return "proyecto/newform";
    }

    @PostMapping("/save")
    public String saveproyecto( Proyecto proyecto){
        proyectoRepository.save(proyecto);
        return "redirect:/proyecto/listar";
    }

    @GetMapping("/editar")
    public String editarproyecto(@RequestParam("id") int id, Model model) {
        Optional<Proyecto> optionalProyecto = proyectoRepository.findById(id);
        if (optionalProyecto.isPresent()) {
            Proyecto proyecto = optionalProyecto.get();
            model.addAttribute("proyecto", proyecto);
            List<UsuarioEntity> usuarioEntityList = usuarioRepository.findAll();
            model.addAttribute("usuarioEntityList", usuarioEntityList);
            List<Actividad> listaActividadesporProyecto = actividadRepository.findByIdproyecto(id);
            model.addAttribute("listaActividadesporProyecto", listaActividadesporProyecto);
            return "proyecto/editform";
        } else {
            return "redirect:/proyecto/listar";
        }
    }

    @GetMapping("/borrar")
    public String borrar(@RequestParam("id") int id){
        Optional<Proyecto> optionalProyecto = proyectoRepository.findById(id);
        if(optionalProyecto.isPresent()){
            proyectoRepository.deleteById(id);
        }
        return "redirect:/proyecto/listar";

    }

}
