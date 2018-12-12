package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Venda;
import com.cccpharmaapi.cccpharmaapi.models.VendaProduto;
import com.cccpharmaapi.cccpharmaapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    private VendaProdutoService  vendaProdutoService = new VendaProdutoServiceImpl();

    @Override
    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    @Override
    public Venda findById(Integer id) {
        Optional<Venda> costumer = vendaRepository.findById(id);
        Venda res = (costumer.isPresent()) ? costumer.get() : null;

        return res;
    }

    @Override
    public Venda create(Venda venda) {
        List<VendaProduto> vendaProdutos = venda.getVendas();

        for (VendaProduto vendaProduto : vendaProdutos)
            vendaProdutoService.create(vendaProduto);

        return vendaRepository.save(venda);
    }
}
