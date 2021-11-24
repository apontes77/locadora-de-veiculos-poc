package com.pucgoias.locadoraveiculos.controllers;

import com.pucgoias.locadoraveiculos.domain.Cliente;
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
@RequestMapping("/api/v1/locadora-veiculos/cliente")
public class ClienteController {
    private final ClienteRepository clienteRepository;

    @GetMapping
    @ResponseBody
    public List<Cliente> listAll(){
        return clienteRepository.findAll();
    }

    @PostMapping()
    @Transactional
    public Cliente postCliente(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente, @PathVariable Long id){
        Optional<Cliente> antigoCliente = clienteRepository.findById(id);
        if(antigoCliente.isEmpty())
            return new ResponseEntity<String>("Cliente não encontrado", HttpStatus.NOT_FOUND);
        cliente.setId(id);
        cliente = clienteRepository.save(cliente);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> deleteCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty())
            return new ResponseEntity<String>("Cliente não encontrado", HttpStatus.NOT_FOUND);
        clienteRepository.deleteById(id);
        return new ResponseEntity<String>("Cliente excluido!", HttpStatus.OK);
    }
}
