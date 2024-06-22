package com.nataldelimati.proquan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class GruposDeCampo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "congregacao")
    private Congregacao congregacao;

    @OneToOne
    @JoinColumn(name = "dirigente_id")
    private Publicadores dirigente;

    @OneToOne
    @JoinColumn(name = "ajudante_id")
    private Publicadores ajudante;
}
