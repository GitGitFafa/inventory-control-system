package com.br.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.estoque.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}