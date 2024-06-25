package com.nataldelimati.proquan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nataldelimati.proquan.entity.Congregacao;
import com.nataldelimati.proquan.service.CongregacaoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/congregacao")
public class CongregacaoFrontController {

    @Autowired

    private CongregacaoService congregacaoService;

    @GetMapping("/cadastro")
    public String showSignUpForm(Congregacao congregacao) {
        return "add-congregacao";
    }

    @PostMapping("/add")
    public String addCongregacao(@Valid @ModelAttribute Congregacao congregacao, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-congregacao";
        }

        congregacaoService.save(congregacao);
        return "redirect:/congregacao";
    }

    @GetMapping("/congregacao")
    public String showCongregacaoList(Model model) {
        model.addAttribute("congregacao", congregacaoService.findAll());
        return "index";
    }

}
