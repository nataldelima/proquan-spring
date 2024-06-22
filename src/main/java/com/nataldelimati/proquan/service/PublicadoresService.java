package com.nataldelimati.proquan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataldelimati.proquan.entity.Publicadores;
import com.nataldelimati.proquan.repository.PublicadoresRepository;

@Service
public class PublicadoresService {

    @Autowired
    private PublicadoresRepository publicadoresRepository;

    public List<Publicadores> findAll() {
        return publicadoresRepository.findAll();
    }

    public Optional<Publicadores> findById(Long id) {
        return publicadoresRepository.findById(id);
    }

    public Publicadores save(Publicadores publicadores) {
        return publicadoresRepository.save(publicadores);
    }

    public void deleteById(Long id) {
        publicadoresRepository.deleteById(id);
    }

}
