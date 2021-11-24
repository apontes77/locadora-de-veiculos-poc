package com.pucgoias.locadoraveiculos.controllers;

import com.pucgoias.locadoraveiculos.domain.Aluguel;
import com.pucgoias.locadoraveiculos.domain.Automovel;
import com.pucgoias.locadoraveiculos.domain.Cliente;
import com.pucgoias.locadoraveiculos.repositories.AluguelRepository;
import com.pucgoias.locadoraveiculos.repositories.AutomovelRepository;
import com.pucgoias.locadoraveiculos.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/locadora-veiculos/automovel")
public class AutomovelController {
    private final AutomovelRepository automovelRepository;

    @GetMapping
    @ResponseBody
    public List<Automovel> listAll(){
        return automovelRepository.findAll();
    }

    @Transactional
    public Automovel postAutomovel(@RequestBody Automovel automovel) {
        return automovelRepository.save(automovel);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateAutomovel(@RequestBody Automovel automovel, @PathVariable Long id){
        Optional<Automovel> antigoAutomovel = automovelRepository.findById(id);
        if(antigoAutomovel.isEmpty())
            return new ResponseEntity<String>("Automovel não encontrado", HttpStatus.NOT_FOUND);
        automovel.setId(id);
        automovel = automovelRepository.save(automovel);
        return new ResponseEntity<Automovel>(automovel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteAutomovel(@PathVariable Long id) {
        Optional<Automovel> automovel = automovelRepository.findById(id);
        if(automovel.isEmpty())
            return new ResponseEntity<String>("Automovel não encontrado", HttpStatus.NOT_FOUND);
        automovelRepository.deleteById(id);
        return new ResponseEntity<String>("Automovel excluido!", HttpStatus.OK);
    }
}