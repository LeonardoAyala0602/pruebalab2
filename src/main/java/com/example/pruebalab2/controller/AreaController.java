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
@RequestMapping("/area")
public class AreaController {

    @Autowired
    AreaRepository areaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public String listarAreas(Model model){
        List<AreaEntity> listaAreas = areaRepository.findAll();
        model.addAttribute("listaAreas",listaAreas);
        return "area/lista";
    }

    @GetMapping("/newform")
    public String newformAreas(){
        return "area/newform";
    }

    @PostMapping("/save")
    public String saveAreas(@RequestParam("idarea") String nombre){
        AreaEntity area = new AreaEntity();
        area.setNombreArea(nombre);
        areaRepository.save(area);
        return "redirect:/area/listar";
    }

    @GetMapping("/editar")
    public String editarAreas(@RequestParam("id") int id, Model model){
        Optional<AreaEntity> optionalArea = areaRepository.findById(id);
        if (optionalArea.isPresent()) {
            AreaEntity area = optionalArea.get();
            model.addAttribute("area", area);
            List<UsuarioEntity> listaUsuarios = usuarioRepository.findByIdarea(id);
            model.addAttribute("listaUsuarios", listaUsuarios);
            return "area/editar";
        } else {
            return "redirect:/area/listar";
        }
    }

    @PostMapping("/edit")
    public String editAreas(AreaEntity area){
        areaRepository.save(area);
        return "redirect:/area/listar";
    }

    @GetMapping("/borrar")
    public String borrarAreas(@RequestParam("id") int id){
        Optional<AreaEntity> optionalUsuario = areaRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            areaRepository.deleteById(id);
        }
        return "redirect:/area/listar";
    }
}
