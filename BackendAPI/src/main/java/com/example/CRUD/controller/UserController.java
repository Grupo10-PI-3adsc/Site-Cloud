package com.example.CRUD.controller;
import com.example.CRUD.entity.UserEntity;
import com.example.CRUD.repository.UserRepository;
import com.example.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> listar() {
        List<UserEntity> cliente = userService.listarCliente();

        if(cliente.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> buscarPorIndice (@PathVariable int id) {
       return ResponseEntity.ok(userService.userPorId(id));
    }

    @PostMapping
    public ResponseEntity<UserEntity> criar(@RequestBody UserEntity funcionarioNovo){

        return ResponseEntity.ok(userService.save(funcionarioNovo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> atualizar(@PathVariable Integer id, @RequestBody UserEntity userEntity){
        if(userRepository.existsById(id)) {
            userEntity.setId(id);
            return ResponseEntity.status(200).body(userRepository.save(userEntity));
        }

        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) {
        if(userRepository.existsById(id)) {
            userService.inativarUser(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

}
