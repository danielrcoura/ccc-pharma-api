package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.models.Lote;
import com.cccpharmaapi.cccpharmaapi.repositories.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LoteServiceImpl implements LoteService{

    @Autowired
    private LoteRepository loteRepository;

    private EstoqueService estoqueService = new EstoqueServiceImpl();

    @Override
    public List<Lote> findAll() {
        return loteRepository.findAll();
    }

    @Override
    public Optional<Lote> findById(Integer id) {
        return loteRepository.findById(id);
    }

    @Override
    public Lote create(Lote lote) {
        Estoque estoque = lote.getEstoque();
        estoqueService.decrementaEstoque(lote.getQuantidade(), estoque.getId());
        return loteRepository.save(lote);
    }

    @Override
    public void delete(Lote lote) {
        Estoque estoque = lote.getEstoque();
        estoqueService.incrementaEstoque(lote.getQuantidade(), estoque.getId());
        loteRepository.deleteById(lote.getId());
    }
}
