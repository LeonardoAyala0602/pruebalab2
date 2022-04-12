package com.example.pruebalab2.controller;

import com.example.pruebalab2.entity.AreaEntity;
import com.example.pruebalab2.entity.UsuarioEntity;
import com.example.pruebalab2.repository.AreaRepository;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    AreaRepository areaRepository;


    @GetMapping("/listar")
    public String listarUsuarios(Model model){
        List<UsuarioEntity> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios",listaUsuarios);
        return "usuario/lista";
    }

    @GetMapping("/newform")
    public String newformUsuarios(Model model){
        List<AreaEntity> listaAreas = areaRepository.findAll();
        model.addAttribute("listaAreas",listaAreas);
        return "usuario/newform";
    }

    @PostMapping("/save")
    public String saveUsuarios(UsuarioEntity usuarioEntity){
        usuarioRepository.save(usuarioEntity);
        return "redirect:/usuario/listar";
    }

    @GetMapping("/editar")
    public String editarUsuarios(@RequestParam("correo") String correo, Model model){
        Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findById(correo);
        if(optionalUsuario.isPresent()){
            UsuarioEntity usuario = optionalUsuario.get();
            model.addAttribute("usuario", usuario);
            List<AreaEntity> listaAreas = areaRepository.findAll();
            model.addAttribute("listaAreas",listaAreas);
            return "usuario/editar";
        }else{
            return "redirect:/usuario/listar";}
    }

    @GetMapping("/borrar")
    public String borrarUsuarios(@RequestParam("correo") String correo){
        Optional<UsuarioEntity> optionalUsuario = usuarioRepository.findById(correo);
            usuarioRepository.deleteById(correo);
        return "redirect:/usuario/listar";
    }
}
