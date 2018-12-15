package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    List<Produto> findAll();

    Optional<Produto> findById(Integer id);

    Produto create(Produto produto);

    void delete(Integer produto);

    Produto update(Produto produto);
}
