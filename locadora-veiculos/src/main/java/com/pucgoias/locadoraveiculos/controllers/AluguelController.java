package com.pucgoias.locadoraveiculos.controllers;

import com.pucgoias.locadoraveiculos.domain.Aluguel;
import com.pucgoias.locadoraveiculos.repositories.AluguelRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/locadora-veiculos/aluguel")
public class AluguelController {
    private final AluguelRepository aluguelRepository;

    @GetMapping
    public List<Aluguel> listAll(){
        return aluguelRepository.findAll();
    }

    @PostMapping()
    @Transactional
    public Aluguel postAluguel(@RequestBody Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateAluguel(@RequestBody Aluguel aluguel, @PathVariable Long id){
        Optional<Aluguel> antigoAluguel = aluguelRepository.findById(id);
        if(antigoAluguel.isEmpty())
            return new ResponseEntity<String>("Aluguel não encontrado", HttpStatus.NOT_FOUND);
        aluguel.setId(id);
        aluguel = aluguelRepository.save(aluguel);
        return new ResponseEntity<Aluguel>(aluguel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteAluguel(@PathVariable Long id) {
        Optional<Aluguel> aluguel = aluguelRepository.findById(id);
        if(aluguel.isEmpty())
            return new ResponseEntity<String>("Aluguel não encontrado", HttpStatus.NOT_FOUND);
        aluguelRepository.deleteById(id);
        return new ResponseEntity<String>("Aluguel excluido!", HttpStatus.OK);
    }
}