package com.prueba_1.controller;

import com.prueba_1.domain.Publicacion;
import com.prueba_1.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Publicacion> publicaciones = publicacionService.findAll();
        model.addAttribute("publicaciones", publicaciones);
        return "listado";
    }

    @GetMapping("/modifica")
    public String modifica(@RequestParam int id, Model model) {
        Publicacion publicacion = publicacionService.findById(id);
        model.addAttribute("publicacion", publicacion);
        return "modifica";
    }

    @PostMapping("/modificarPublicacion")
    public String modificarPublicacion(@ModelAttribute Publicacion publicacion, @RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
           
                String imageUrl = uploadImageToFirebase(file);
                publicacion.setImagen(imageUrl);
            } catch (IOException e) {
               
                
            }
        }
        publicacionService.save(publicacion);
        return "redirect:/publicaciones/listado";
    }

    private String uploadImageToFirebase(MultipartFile file) throws IOException {
        //

        return "http://example.com/imagen_subida.jpg"; 
    }
}