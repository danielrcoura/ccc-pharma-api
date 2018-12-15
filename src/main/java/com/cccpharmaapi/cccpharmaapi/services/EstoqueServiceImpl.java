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
    public boolean decrementaEstoque(Integer estoqueId, int valor) {
        Optional<Estoque> costumer = estoqueRepository.findById(estoqueId);

        if(costumer.isPresent()) {
            Estoque estoque = costumer.get();
            int newQuantidade = estoque.getQuantidade() - valor;
            newQuantidade = (newQuantidade < 0) ? 0 : newQuantidade;
            estoque.setQuantidade(newQuantidade);
            newQuantidade *= -1;
            if (newQuantidade > 0) {
                Optional<List<Estoque>> estoquesCostumer = estoqueRepository.findEstoqueMenorValidade(estoqueId);
                List<Estoque> estoques = (estoquesCostumer.isPresent()) ? estoquesCostumer.get() : null;
                if (estoques == null) return false;
                int i = 0;
                while (i < estoques.size() && estoques.get(i).getQuantidade() > 0) i++;
                if (i < estoques.size()) decrementaEstoque(estoques.get(i).getId(), newQuantidade);
                else return false;
            }
            this.update(estoque);
            return true;
        } else return false;
    }

    @Override
    public Estoque getEstoqueMenorValidade(Produto produto) {
        Integer codigo = produto.getId();
        Optional<List<Estoque>> estoquesCostumer = estoqueRepository.findEstoqueMenorValidade(codigo);
        List<Estoque> estoques = (estoquesCostumer.isPresent()) ? estoquesCostumer.get() : null;
        Estoque res = (estoques.size() > 0) ? estoques.get(0) : null;

        return res;
    }
}
