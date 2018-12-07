package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    List<Produto> findAll();

    Optional<Produto> findById(Integer id);

    Optional<Produto> findByCodigo(String codigo);

    Produto create(Produto produto);

    void delete(Produto produto);

    Produto update(Produto produto);
}
