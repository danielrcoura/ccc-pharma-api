package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.models.Produto;

import java.util.List;

public interface EstoqueService {

    List<Estoque> findAll();

    Estoque findById(Integer id);

    Estoque create(Estoque estoque);

    Estoque update(Estoque estoque);
}
