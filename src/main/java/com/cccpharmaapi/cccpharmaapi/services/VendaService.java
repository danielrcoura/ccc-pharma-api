package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Venda;

import java.util.List;
import java.util.Optional;

public interface VendaService {

    List<Venda> findAll();

    Optional<Venda> findById(Integer id);

    Venda create(Venda venda);

    Venda update(Venda venda);

    void delete(Venda venda);
}
