package com.example.CRUD.controller;

import com.example.CRUD.dto.MaoDeObraDTO;
import com.example.CRUD.dto.ProdutoDTO;
import com.example.CRUD.entity.MaoDeObrEntity;
import com.example.CRUD.entity.ProdutoEntity;
import com.example.CRUD.repository.MaoDeObraRepository;
import com.example.CRUD.repository.ProdutoRepository;
import com.example.CRUD.service.MaoDeObraService;
import com.example.CRUD.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class PedidoController {

    @Autowired
    private ProdutoRepository pedidoProdutoRepository;
    @Autowired
    private ProdutoService pedidoProdutoService;


    @Autowired
    private MaoDeObraRepository maoDeObraRepository;
    @Autowired
    private MaoDeObraService maoDeObraService;

    @GetMapping()
    public ResponseEntity<List<ProdutoEntity>> listar() {
        List<ProdutoEntity> produtoOpt = pedidoProdutoRepository.findAll();
        if(produtoOpt.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produtoOpt);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar(@PathVariable int id) {
        Optional<ProdutoEntity> produto = pedidoProdutoRepository.findById(id);

        if(produto.isPresent()) {
            return ResponseEntity.status(200).body(produto.get());
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping()
    public ResponseEntity<ProdutoEntity> criar(@RequestBody ProdutoDTO produtoNovo) {
        produtoNovo.setId(null);
        return ResponseEntity.status(201).body(pedidoProdutoService.save(produtoNovo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoEntity> atualizar(@PathVariable Integer id, @RequestBody ProdutoEntity produto) {
        if(pedidoProdutoRepository.existsById(id)) {
            produto.setId(id);
            return ResponseEntity.status(200).body(pedidoProdutoRepository.save(produto));
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if(pedidoProdutoRepository.existsById(id)) {
            pedidoProdutoRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity<String> pedidoProduto() {

        List<ProdutoEntity> maoDeObraOPT = pedidoProdutoRepository.findAll();

        Double total = 0.0;
        if (!maoDeObraOPT.isEmpty()) {
            for (int i = 0; i < maoDeObraOPT.size(); i++) {
                total += maoDeObraOPT.get(i).calcularPreco();
            }
            return ResponseEntity.status(200).body("Preço total de todos os pedidos de Mão de Obra: R$" + total);
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<String> pedidoIdProduto(@PathVariable Integer id) {

        Optional<ProdutoEntity> maoDeObraOPT = pedidoProdutoRepository.findById(id);

        if (maoDeObraOPT.isPresent()) {
            return ResponseEntity.status(200).body("Preço total de todos os pedidos de Produto: R$" + maoDeObraOPT.get().calcularPreco());
        }
        return ResponseEntity.status(204).build();
    }


//
//    @GetMapping("/mao-de-obra")
//    public ResponseEntity<List<MaoDeObrEntity>> listarMaoDeObra() {
//        List<MaoDeObrEntity> maoDeObraOPT = maoDeObraRepository.findAll();
//
//        if(maoDeObraOPT.isEmpty()) {
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(200).body(maoDeObraOPT);
//    }
//
//    @GetMapping("/mao-de-obra/{id}")
//    public ResponseEntity<MaoDeObrEntity> atualizarMaoDeObra(@PathVariable int id) {
//        Optional<MaoDeObrEntity> maoDeObra = maoDeObraRepository.findById(id);
//
//        if(maoDeObra.isPresent()) {
//            return ResponseEntity.status(200).body(maoDeObra.get());
//        }
//
//        return ResponseEntity.status(404).build();
//    }
//
//    @PostMapping("/mao-de-obra")
//    public ResponseEntity<MaoDeObrEntity> criarMaoDeObra(@RequestBody MaoDeObraDTO maoDeObraNovo) {
//        maoDeObraNovo.setId(null);
//        return ResponseEntity.status(201).body(maoDeObraService.save(maoDeObraNovo));
//    }
//
//    @PutMapping("/mao-de-obra/{id}")
//    public ResponseEntity<MaoDeObrEntity> atualizar(@PathVariable Integer id, @RequestBody MaoDeObrEntity maoDeObra) {
//        if(maoDeObraRepository.existsById(id)) {
//            maoDeObra.setId(id);
//            return ResponseEntity.status(200).body(maoDeObraRepository.save(maoDeObra));
//        }
//        return ResponseEntity.status(404).build();
//    }
//
//    @DeleteMapping("/mao-de-obra/{id}")
//    public ResponseEntity<Void> deletarMaoDeObra(@PathVariable Integer id) {
//        if(maoDeObraRepository.existsById(id)) {
//            maoDeObraRepository.deleteById(id);
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(404).build();
//    }
}