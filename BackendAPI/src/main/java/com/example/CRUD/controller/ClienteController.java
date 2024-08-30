package com.example.CRUD.controller;

import com.example.CRUD.entity.ClienteEntity;
import com.example.CRUD.repository.ClienteRepository;
import com.example.CRUD.service.ClienteService;
import com.example.CRUD.dto.ClienteDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<ClienteEntity>> listar() {
        List<ClienteEntity> cliente = clienteRepository.findAll();

        if(cliente.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscarPorIndice (@PathVariable int id) {
        Optional<ClienteEntity> profissaoOpt = clienteRepository.findById(id);
        if(profissaoOpt.isPresent()) {
            return ResponseEntity.status(201).body(profissaoOpt.get());
        }
        return ResponseEntity.status(204).build();
    }
    
    @PostMapping
    public ResponseEntity<ClienteEntity> criar(@RequestBody ClienteDTO clienteNovo){
        clienteNovo.setId(null);
        return ResponseEntity.status(201).body(clienteService.save(clienteNovo));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> atualizar(@PathVariable Integer id, @RequestBody ClienteEntity clienteEntity){
        if(clienteRepository.existsById(id)) {
            clienteEntity.setId(id);
            return ResponseEntity.status(200).body(clienteEntity);
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deeltarCliente(@PathVariable Integer id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }



}
