package com.nataldelimati.proquan.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity

public class Publicadores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String primeiroNome;
    private String nomeMeio;
    private String sobrenome;
    private LocalDate dataNascimento;
    private LocalDate dataBatismo;
    private String sexo;

    private String privilegios;

    @OneToOne
    @JoinColumn(name = "grupo_campo")
    private GruposDeCampo grupoCampo;

    private String endereco;
    private String telefone;
    private String contatoEmergencia;
    private String telContatoEmergencia;
    private boolean contatoEmergenciaEhTj;
    private boolean ativo;
}
