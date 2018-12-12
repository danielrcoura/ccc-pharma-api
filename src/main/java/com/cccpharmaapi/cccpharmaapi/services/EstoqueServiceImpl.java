package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.models.Produto;
import com.cccpharmaapi.cccpharmaapi.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Override
    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    @Override
    public Estoque findById(Integer id) {
        Optional<Estoque> costumer = estoqueRepository.findById(id);
        Estoque res = (costumer.isPresent()) ? costumer.get() : null;

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
    public void decrementaEstoque(Integer estoqueId, int valor) {
        Optional<Estoque> costumer = estoqueRepository.findById(estoqueId);

        if(costumer.isPresent()) {
            Estoque estoque = costumer.get();
            int newQuantidade = estoque.getQuantidade() - valor;
            newQuantidade = (newQuantidade < 0) ? 0 : newQuantidade;
            estoque.setQuantidade(newQuantidade);
            this.update(estoque);
        }
    }

    @Override
    public Estoque getEstoqueMenorValidade(Produto produto) {
        List<Estoque> costumer = estoqueRepository.findEstoqueMenorValidade(produto.getCodigo());
        Estoque res = (costumer.size() > 0) ? costumer.get(0) : null;

        return res;
    }
}
