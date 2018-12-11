package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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
        Optional<Estoque> costumer = this.findById(estoqueId);
        boolean res = false;
        if (costumer.isPresent()) {
            Date estoqueValidade = costumer.get().getValidade();
            Date currentDate = new Date(System.currentTimeMillis());
            res = estoqueValidade.compareTo(currentDate) > -1;
        }

        return res;
    }

    @Override
    public Boolean verifyQuantidade(Integer estoqueId) {
        Optional<Estoque> costumer = this.findById(estoqueId);
        boolean res = false;

        if (costumer.isPresent()) {
            int estoqueQuantidade = costumer.get().getQuantidade();
            res = estoqueQuantidade > 0;
        }

        return res;
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

    @Override
    public void decrementaEstoque(Integer estoqueId, int valor) {
        Optional<Estoque> costumer = this.findById(estoqueId);

        if (costumer.isPresent()) {
            Estoque estoque = costumer.get();
            int newEstoque = ((estoque.getQuantidade() - valor) >= 0) ? (estoque.getQuantidade() - valor) : 0;
            estoque.setQuantidade(newEstoque);
        }
    }

    @Override
    public void incrementaEstoque(Integer estoqueId, int valor) {
        Optional<Estoque> costumer = this.findById(estoqueId);

        if (costumer.isPresent()) {
            Estoque estoque = costumer.get();
            int newEstoque = estoque.getQuantidade() + valor;
            estoque.setQuantidade(newEstoque);
        }
    }
}
