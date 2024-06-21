package com.nataldelimati.proquan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nataldelimati.proquan.entity.GruposDeCampo;
import com.nataldelimati.proquan.service.GruposDeCampoService;

@RestController
@RequestMapping("/grupos-de-campo")
public class GruposDeCampoController {
    @Autowired
    private GruposDeCampoService gruposDeCampoService;

    @GetMapping
    public List<GruposDeCampo> getAllGruposDeCampo() {
        return gruposDeCampoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GruposDeCampo> getGruposDeCampoById(@PathVariable Long id) {
        return gruposDeCampoService.findById(id)
                .map(gruposDeCampo -> ResponseEntity.ok().body(gruposDeCampo))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public GruposDeCampo createGruposDeCampo(@RequestBody GruposDeCampo gruposDeCampo) {
        return gruposDeCampoService.save(gruposDeCampo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GruposDeCampo> updateGrupoDeCampResponseEntity(@PathVariable Long id,
            @RequestBody GruposDeCampo grupoDeCampoDetalhes) {

        return gruposDeCampoService.findById(id)
                .map(grupoDeCampo -> {
                    grupoDeCampo.setNome(grupoDeCampoDetalhes.getNome());
                    grupoDeCampo.setCongregacao(grupoDeCampoDetalhes.getCongregacao());
                    grupoDeCampo.setDirigente(grupoDeCampoDetalhes.getDirigente());
                    grupoDeCampo.setAjudante(grupoDeCampoDetalhes.getAjudante());
                    GruposDeCampo updatedGrupoDeCampo = gruposDeCampoService.save(grupoDeCampo);
                    return ResponseEntity.ok().body(updatedGrupoDeCampo);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupoDeCampo(@PathVariable Long id) {
        return gruposDeCampoService.findById(id)
                .map(grupoDeCampo -> {
                    gruposDeCampoService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
