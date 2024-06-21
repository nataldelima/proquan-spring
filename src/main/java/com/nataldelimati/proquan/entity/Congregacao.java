package com.nataldelimati.proquan.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Congregacao {
    @Id
    private Long nro;

    private String nome;
    private String endereco;
    private String circuito;

    @Column(name = "supte_circuito")
    private String supteCircuito;

    @Column(name = "tel_supte_circuito")
    private String telSupteCircuito;

}
