package com.empresa.foco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/resumen")
    public String mostrarResumen() {
        return "resumen";
    }
}
