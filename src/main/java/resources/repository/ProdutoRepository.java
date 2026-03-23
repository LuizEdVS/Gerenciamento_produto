package com.gerenciamento.produto.repository;

import com.gerenciamento.produto.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
a
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
