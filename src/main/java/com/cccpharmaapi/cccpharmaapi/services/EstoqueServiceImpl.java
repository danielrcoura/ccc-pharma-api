package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.Util.EstoqueComparator;
import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.models.Produto;
import com.cccpharmaapi.cccpharmaapi.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /*
    public List<Estoque> findEstoqueMenorValidade(Integer produtoId) {
        List<Estoque> estoques = this.findAll();
        List<Estoque> estoqueProduto = new ArrayList<>();
        for (Estoque estoque : estoques) {
            if (estoque.getProduto().getId() == produtoId) {
                estoqueProduto.add(estoque);
            }
        }
        EstoqueComparator comparator = new EstoqueComparator();
        estoqueProduto.sort(comparator);
        return estoqueProduto;
    }

    @Override
    public boolean decrementaEstoque(Integer estoqueId, int valor) {
        Optional<Estoque> costumer = estoqueRepository.findById(estoqueId);

        if(costumer.isPresent()) {
            Estoque estoque = costumer.get();
            Integer productId = estoque.getProduto().getId();
            int newQuantidade = estoque.getQuantidade() - valor;
            newQuantidade = (newQuantidade < 0) ? 0 : newQuantidade;
            estoque.setQuantidade(newQuantidade);
            newQuantidade *= -1;
            if (newQuantidade > 0) {
                List<Estoque> estoques = findEstoqueMenorValidade(productId);
                if (estoques.size() == 0) return false;
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
        Integer produtoid = produto.getId();
        List<Estoque> estoques = findEstoqueMenorValidade(produtoid);
        Estoque res = (estoques.size() > 0) ? estoques.get(0) : null;

        return res;
    }
    */
}
