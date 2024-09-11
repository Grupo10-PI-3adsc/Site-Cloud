package com.example.CRUD.controller;

import com.example.CRUD.dto.MaoDeObraDTO;
import com.example.CRUD.entity.MaoDeObrEntity;
import com.example.CRUD.entity.ProdutoEntity;
import com.example.CRUD.repository.MaoDeObraRepository;
import com.example.CRUD.service.MaoDeObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mao-de-obra")
public class MaoDeObraController {



    @Autowired
    private MaoDeObraRepository maoDeObraRepository;
    @Autowired
    private MaoDeObraService maoDeObraService;


    @GetMapping()
    public ResponseEntity<List<MaoDeObrEntity>> listarMaoDeObra() {
        List<MaoDeObrEntity> maoDeObraOPT = maoDeObraRepository.findAll();

        if(maoDeObraOPT.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(maoDeObraOPT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaoDeObrEntity> atualizarMaoDeObra(@PathVariable int id) {
        Optional<MaoDeObrEntity> maoDeObra = maoDeObraRepository.findById(id);

        if(maoDeObra.isPresent()) {
            return ResponseEntity.status(200).body(maoDeObra.get());
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping()
    public ResponseEntity<MaoDeObrEntity> criarMaoDeObra(@RequestBody MaoDeObraDTO maoDeObraNovo) {
        maoDeObraNovo.setId(null);
        return ResponseEntity.status(201).body(maoDeObraService.save(maoDeObraNovo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaoDeObrEntity> atualizar(@PathVariable Integer id, @RequestBody MaoDeObrEntity maoDeObra) {
        if(maoDeObraRepository.existsById(id)) {
            maoDeObra.setId(id);
            return ResponseEntity.status(200).body(maoDeObraRepository.save(maoDeObra));
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMaoDeObra(@PathVariable Integer id) {
        if(maoDeObraRepository.existsById(id)) {
            maoDeObraRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }


    @GetMapping("/pedidos")
    public ResponseEntity<String> listarPedidos() {
        List<MaoDeObrEntity> produtoOpt = maoDeObraRepository.findAll();
        if(produtoOpt.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        Double total = 0.0;
        for (int i = 0; i < produtoOpt.size(); i++) {
            total += produtoOpt.get(i).calcularPedido();
        }
        return ResponseEntity.status(200).body("O total de todos os pedidos de mao de obra: RS" + total);
    }


    @GetMapping("/pedidos/{id}")
    public ResponseEntity<String> listarPedidos(@PathVariable Integer id) {
        Optional<MaoDeObrEntity> produtoOpt = maoDeObraRepository.findById(id);
        if(produtoOpt.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body("O total de um unico pedido de mao de obra: RS" + produtoOpt.get().calcularPedido());
    }

}
