package com.nataldelimati.proquan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataldelimati.proquan.entity.GruposDeCampo;
import com.nataldelimati.proquan.repository.GruposDeCampoRepository;

@Service
public class GruposDeCampoService {

    @Autowired
    private GruposDeCampoRepository gruposDeCampoRepository;

    public List<GruposDeCampo> findAll() {
        return gruposDeCampoRepository.findAll();
    }

    public Optional<GruposDeCampo> findById(Long id) {
        return gruposDeCampoRepository.findById(id);
    }

    public GruposDeCampo save(GruposDeCampo gruposDeCampo) {
        return gruposDeCampoRepository.save(gruposDeCampo);
    }

    public void deleteById(Long id) {
        gruposDeCampoRepository.deleteById(id);
    }

}
