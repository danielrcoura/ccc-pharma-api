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
    public Optional<Venda> findById(Integer id) {
        return vendaRepository.findById(id);
    }

    @Override
    public Venda create(Venda venda) {
        List<VendaProduto> vendaProdutos = venda.getVendas();

        for (VendaProduto vendaProduto : vendaProdutos)
            vendaProdutoService.create(vendaProduto);

        return vendaRepository.save(venda);
    }

    @Override
    public void delete(Venda venda) {
        vendaRepository.deleteById(venda.getVendaId());
    }
}
