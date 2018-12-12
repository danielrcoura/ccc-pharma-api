package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;

import java.util.List;
import java.util.Optional;

public interface EstoqueService {

    List<Estoque> findAll();

    Optional<Estoque> findById(Integer id);

    Estoque create(Estoque estoque);

    Estoque update(Estoque estoque);

    void delete(Estoque estoque);
}
