package com.nataldelimati.proquan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nataldelimati.proquan.entity.Congregacao;
import com.nataldelimati.proquan.service.CongregacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/congregacao")
public class CongregacaoController {

    @Autowired
    private CongregacaoService congregacaoService;

    @GetMapping("/congregacoes/cadastro")
    public String showSignUpForm(Congregacao congregacao) {
        return "add-congregacao";
    }

    @PostMapping("/congregacoes/add")
    public String addCongregacao(@Valid @ModelAttribute Congregacao congregacao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-congregacao";
        }

        congregacaoService.save(congregacao);
        return "redirect:/congregacoes";
    }

    @GetMapping("/congregacoes")
    public String showCongregacaoList(Model model) {
        model.addAttribute("congregacoes", congregacaoService.findAll());
        return "index";
    }

    @GetMapping
    public List<Congregacao> getAllCongregacoes() {
        return congregacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Congregacao> getCongregacaoById(@PathVariable Long id) {
        return congregacaoService.findById(id)
                .map(congregacao -> ResponseEntity.ok().body(congregacao)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Congregacao createCongregacao(@RequestBody Congregacao congregacao) {
        return congregacaoService.save(congregacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Congregacao> updateCongregacao(@PathVariable Long id,
            @RequestBody Congregacao congregacaoDetalhes) {
        return congregacaoService.findById(id)
                .map(congregacao -> {
                    congregacao.setNro(congregacaoDetalhes.getNro());
                    congregacao.setNome(congregacaoDetalhes.getNome());
                    congregacao.setEndereco(congregacaoDetalhes.getEndereco());
                    congregacao.setCircuito(congregacaoDetalhes.getCircuito());
                    congregacao.setSupteCircuito(congregacaoDetalhes.getSupteCircuito());
                    congregacao.setTelSupteCircuito(congregacaoDetalhes.getTelSupteCircuito());
                    Congregacao updatedCongregacao = congregacaoService.save(congregacao);
                    return ResponseEntity.ok().body(updatedCongregacao);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCongregacao(@PathVariable Long id) {
        return congregacaoService.findById(id)
                .map(congregacao -> {
                    congregacaoService.deleteById(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
