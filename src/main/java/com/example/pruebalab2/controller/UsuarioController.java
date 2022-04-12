package com.example.pruebalab2.controller;

import com.example.pruebalab2.entity.UsuarioEntity;
import com.example.pruebalab2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public String listarUsuarios(Model model){
        List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios",listaUsuarios);
        return "usuario/lista";
    }
}
