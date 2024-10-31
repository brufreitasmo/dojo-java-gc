package com.geracaocaldeira.java.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Classificacao cassificacao;
    @Enumerated(EnumType.STRING)
    private StatusMissao statusMissao;
    @Enumerated(EnumType.STRING)
    private TipoMissao tipoMissao;
    @ManyToOne
    @JoinColumn(name = "id")
    private Ninja ninja;
}
