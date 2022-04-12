package com.example.pruebalab2.controller;


import com.example.pruebalab2.entity.Proyecto;
import com.example.pruebalab2.entity.UsuarioEntity;
import com.example.pruebalab2.repository.ProyectoRepository;
import com.example.pruebalab2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/proyecto")

public class ProyectoController {

    @Autowired
    ProyectoRepository proyectoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

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
}
