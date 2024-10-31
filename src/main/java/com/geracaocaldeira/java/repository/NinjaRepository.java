package com.geracaocaldeira.java.repository;

import com.geracaocaldeira.java.model.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Ninja, Integer> {
}
