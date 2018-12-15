package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Produto;
import com.cccpharmaapi.cccpharmaapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Optional<Produto> findById(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void delete(Integer produto) {
        produtoRepository.deleteById(produto);
    }

    @Override
    public Produto update(Produto produto) {
        return produtoRepository.saveAndFlush(produto);
    }
}
