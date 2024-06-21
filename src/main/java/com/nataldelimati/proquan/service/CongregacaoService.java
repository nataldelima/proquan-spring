package com.nataldelimati.proquan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataldelimati.proquan.entity.Congregacao;
import com.nataldelimati.proquan.repository.CongregacaoRepository;

@Service
public class CongregacaoService {

    @Autowired
    private CongregacaoRepository congregacaoRepository;

    public List<Congregacao> findAll() {
        return congregacaoRepository.findAll();
    }

    public Optional<Congregacao> findById(Long id) {
        return congregacaoRepository.findById(id);
    }

    public Congregacao save(Congregacao congregacao) {
        return congregacaoRepository.save(congregacao);
    }

    public void deleteById(Long id) {
        congregacaoRepository.deleteById(id);
    }

}
