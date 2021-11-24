package com.pucgoias.locadoraveiculos.controllers;

import com.pucgoias.locadoraveiculos.domain.Funcionario;
import com.pucgoias.locadoraveiculos.repositories.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/locadora-veiculos/funcionario")
public class FuncionarioController {
    private final FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<Funcionario> listAll(){
        return funcionarioRepository.findAll();
    }

    @PostMapping("/inserir")
    @Transactional
    public Funcionario postFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<?> updateFuncionario(@RequestBody Funcionario funcionario, @PathVariable Long id){
        Optional<Funcionario> antigoFuncionario = funcionarioRepository.findById(id);
        if(antigoFuncionario.isEmpty())
            return new ResponseEntity<String>("Funcionario não encontrado", HttpStatus.NOT_FOUND);
        funcionario.setId(id);
        funcionario = funcionarioRepository.save(funcionario);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    @Transactional
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if(funcionario.isEmpty())
            return new ResponseEntity<String>("Funcionario não encontrado", HttpStatus.NOT_FOUND);
        funcionarioRepository.deleteById(id);
        return new ResponseEntity<String>("Funcionario excluido!", HttpStatus.OK);
    }
}