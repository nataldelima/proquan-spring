package com.nataldelimati.proquan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class GruposDeCampo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "congregacao_id")
    private Congregacao congregacao;

    private Long dirigente;

    private Long ajudante;
}
