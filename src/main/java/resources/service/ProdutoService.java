package com.gerenciamento.produto.service;

import com.gerenciamento.produto.domain.Produto;
import com.gerenciamento.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public Produto criar(Produto produto) {
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    @Transactional(readOnly = true)
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public Optional<Produto> atualizar(Long id, Produto dados) {
        return produtoRepository.findById(id).map(existente -> {
            existente.setNome(dados.getNome());
            existente.setPreco(dados.getPreco());
            existente.setEstoque(dados.getEstoque());
            return produtoRepository.save(existente);
        });
    }

    @Transactional
    public boolean remover(Long id) {
        if (!produtoRepository.existsById(id)) {
            return false;
        }
        produtoRepository.deleteById(id);
        return true;
    }
}
