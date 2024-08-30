package com.example.CRUD.controller;

import com.example.CRUD.dto.ProdutoDTO;
import com.example.CRUD.entity.ProdutoEntity;
import com.example.CRUD.repository.ProdutoRepository;
import com.example.CRUD.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoEntity>> listar() {
        List<ProdutoEntity> produtoOpt = produtoRepository.findAll();
        if(produtoOpt.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produtoOpt);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar(@PathVariable int id) {
        Optional<ProdutoEntity> produto = produtoRepository.findById(id);

        if(produto.isPresent()) {
            return ResponseEntity.status(200).body(produto.get());
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<ProdutoEntity> criar(@RequestBody ProdutoDTO produtoNovo) {
        produtoNovo.setId(null);
        return ResponseEntity.status(201).body(produtoService.save(produtoNovo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar(@PathVariable Integer id, @RequestBody ProdutoEntity produto) {
        if(produtoRepository.existsById(id)) {
            produto.setId(id);
            return ResponseEntity.status(200).body(produto);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
        if(produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
