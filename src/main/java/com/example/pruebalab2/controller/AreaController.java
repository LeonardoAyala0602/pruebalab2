package com.example.pruebalab2.controller;

import com.example.pruebalab2.entity.AreaEntity;
import com.example.pruebalab2.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/area")
public class AreaController {

    @Autowired
    AreaRepository areaRepository;

    @GetMapping("/listar")
    public String listarAreas(Model model){
        List<AreaEntity> listaAreas = areaRepository.findAll();
        model.addAttribute("listaAreas",listaAreas);
        return "area/lista";
    }

}
