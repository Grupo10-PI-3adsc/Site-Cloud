package com.example.CRUD.repository;

import com.example.CRUD.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Integer> {

    List<ProdutoEntity> findAllByCategoria(String categoria);

    @Query("SELECT SUM(p.qtdProdutoEstoque) FROM ProdutoEntity p")
    Long sumQuantidade();
}
