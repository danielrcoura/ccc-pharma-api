package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.VendaProduto;

import java.util.List;
import java.util.Optional;

public interface VendaProdutoService {

    List<VendaProduto> findAll();

    VendaProduto findById(Integer id);

    VendaProduto create(VendaProduto vendaProduto);
}
