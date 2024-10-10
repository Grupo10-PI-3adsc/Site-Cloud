package com.example.CRUD.controller;
import com.example.CRUD.entity.FuncionarioEntity;
import com.example.CRUD.repository.FuncionarioRepository;
import com.example.CRUD.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class UserController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioEntity>> listar() {
        List<FuncionarioEntity> cliente = funcionarioService.listarCliente();

        if(cliente.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioEntity> buscarPorIndice (@PathVariable int id) {
       return ResponseEntity.ok(funcionarioService.clientePorId(id));
    }

    @PostMapping
    public ResponseEntity<FuncionarioEntity> criar(@RequestBody FuncionarioEntity funcionarioNovo){

        return ResponseEntity.ok(funcionarioService.save(funcionarioNovo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioEntity> atualizar(@PathVariable Integer id, @RequestBody FuncionarioEntity funcionarioEntity){
        if(funcionarioRepository.existsById(id)) {
            funcionarioEntity.setId(id);
            return ResponseEntity.status(200).body(funcionarioRepository.save(funcionarioEntity));
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) {
        if(funcionarioRepository.existsById(id)) {
            funcionarioService.inativarCliente(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

}
