package com.nataldelimati.proquan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nataldelimati.proquan.entity.Publicadores;
import com.nataldelimati.proquan.service.PublicadoresService;

@Controller
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

    @PutMapping("/{id}")
    public ResponseEntity<Publicadores> updatePublicadores(@PathVariable Long id,
            @RequestBody Publicadores publicadoresDetalhes) {
        return publicadoresService.findById(id)
                .map(publicadores -> {
                    publicadores.setPrimeiroNome(publicadoresDetalhes.getPrimeiroNome());
                    publicadores.setNomeMeio(publicadoresDetalhes.getNomeMeio());
                    publicadores.setSobrenome(publicadoresDetalhes.getSobrenome());
                    publicadores.setDataNascimento(publicadoresDetalhes.getDataNascimento());
                    publicadores.setDataBatismo(publicadoresDetalhes.getDataBatismo());
                    publicadores.setSexo(publicadoresDetalhes.getSexo());
                    publicadores.setPrivilegios(publicadoresDetalhes.getPrivilegios());
                    publicadores.setGrupoCampo(publicadoresDetalhes.getGrupoCampo());
                    publicadores.setEndereco(publicadoresDetalhes.getEndereco());
                    publicadores.setTelefone(publicadoresDetalhes.getTelefone());
                    publicadores.setContatoEmergencia(publicadoresDetalhes.getContatoEmergencia());
                    publicadores.setTelContatoEmergencia(publicadoresDetalhes.getTelContatoEmergencia());
                    publicadores.setContatoEmergenciaEhTj(publicadoresDetalhes.isContatoEmergenciaEhTj());
                    publicadores.setAtivo(publicadoresDetalhes.isAtivo());
                    Publicadores updatedPublicadores = publicadoresService.save(publicadores);
                    return ResponseEntity.ok().body(updatedPublicadores);
                })
                .orElse(ResponseEntity.notFound().build());
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
