package com.geracaocaldeira.java.repository;

import com.geracaocaldeira.java.model.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<Missao, Integer> {
}
