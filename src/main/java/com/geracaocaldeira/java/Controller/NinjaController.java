package com.geracaocaldeira.java.Controller;

import com.geracaocaldeira.java.model.Ninja;
import com.geracaocaldeira.java.repository.NinjaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
@CrossOrigin("*")
@AllArgsConstructor
public class NinjaController {
    @Autowired
    private NinjaRepository ninjaRepository;

    @GetMapping
    public ResponseEntity<List<Ninja>> listar() {
        List<Ninja> ninjas = ninjaRepository.findAll();
        return new ResponseEntity<>(ninjas, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ninja> buscar(@PathVariable Integer id) {
        return ninjaRepository.findById(id)
                .map(ninja -> new ResponseEntity<>(ninja, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Ninja> criar(@RequestBody Ninja ninja) {
        Ninja novoNinja = ninjaRepository.save(ninja);
        return new ResponseEntity<>(novoNinja, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ninja> atualizar(@PathVariable Integer id, @RequestBody Ninja ninjaAtualizado) {
        return ninjaRepository.findById(id)
                .map(ninja -> {
                    ninjaAtualizado.setId(id);
                    Ninja updatedNinja = ninjaRepository.save(ninjaAtualizado);
                    return new ResponseEntity<>(updatedNinja, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (ninjaRepository.existsById(id)) {
            ninjaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

