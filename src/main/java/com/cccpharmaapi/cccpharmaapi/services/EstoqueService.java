package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;

import java.util.List;
import java.util.Optional;

public interface EstoqueService {

    List<Estoque> findAll();

    Optional<Estoque> findById(Integer id);

    Boolean verifyValidade(Integer estoqueId);

    Boolean verifyQuantidade(Integer estoqueId);

    Estoque create(Estoque estoque);

    Estoque update(Estoque estoque);

    void delete(Estoque estoque);

    void decrementaEstoque(Integer estoqueId, int valor);

    void incrementaEstoque(Integer estoqueId, int valor);
}
