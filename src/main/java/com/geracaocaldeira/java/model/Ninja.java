package com.geracaocaldeira.java.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String vila;
    @Enumerated(EnumType.STRING)
    private StatusNinja status;
    @Enumerated(EnumType.STRING)
    private Experiencia nivelExperiencia;

    public void setId(Integer id) {
    }
}
