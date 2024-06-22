package com.nataldelimati.proquan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nataldelimati.proquan.entity.Publicadores;
import com.nataldelimati.proquan.service.PublicadoresService;

@RestController
@RequestMapping("/publicadores")
public class PublicadoresController {
    @Autowired
    private PublicadoresService publicadoresService;

    @GetMapping
    public List<Publicadores> getAllPublicadores() {
        return publicadoresService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicadores> getPublicadoresById(@PathVariable Long id) {
        return publicadoresService.findById(id)
                .map(publicadores -> ResponseEntity.ok().body(publicadores))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publicadores createPublicadores(@RequestBody Publicadores publicadores) {
        return publicadoresService.save(publicadores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublicadores(@PathVariable Long id) {
        return publicadoresService.findById(id)
                .map(publicadores -> {
                    publicadoresService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
