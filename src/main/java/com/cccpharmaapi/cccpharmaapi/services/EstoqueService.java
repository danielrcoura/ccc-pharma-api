package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.models.Produto;

import java.util.List;
import java.util.Optional;

public interface EstoqueService {

    List<Estoque> findAll();

    Optional<Estoque> findById(Integer id);

    Estoque create(Estoque estoque);

    Estoque update(Estoque estoque);

    void delete(Estoque estoque);

    void decrementaEstoque(Integer estoqueId, int valor);

    Estoque getEstoqueMenorValidade(Produto produto);
}
