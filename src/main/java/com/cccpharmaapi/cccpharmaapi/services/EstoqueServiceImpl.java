package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    @Override
    public Optional<Estoque> findById(Integer id) {
        return estoqueRepository.findById(id);
    }

    @Override
    public Boolean verifyValidade(Integer estoqueId) {
        return null;
    }

    @Override
    public Boolean verifyQuantidade(Integer estoqueId) {
        return null;
    }

    @Override
    public Estoque create(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    @Override
    public Estoque update(Estoque estoque) {
        return estoqueRepository.saveAndFlush(estoque);
    }

    @Override
    public void delete(Estoque estoque) {
        estoqueRepository.deleteById(estoque.getId());
    }
}
