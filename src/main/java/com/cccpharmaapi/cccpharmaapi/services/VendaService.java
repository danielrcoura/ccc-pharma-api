package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Venda;

import java.util.List;
import java.util.Optional;

public interface VendaService {

    List<Venda> findAll();

    Venda findById(Integer id);

    Venda create(Venda venda);
}
