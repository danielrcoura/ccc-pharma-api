package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.models.Produto;
import com.cccpharmaapi.cccpharmaapi.models.VendaProduto;
import com.cccpharmaapi.cccpharmaapi.repositories.VendaProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaProdutoServiceImpl implements VendaProdutoService {

    @Autowired
    private VendaProdutoRepository vendaProdutoRepository;

    private EstoqueService estoqueService = new EstoqueServiceImpl();

    @Override
    public List<VendaProduto> findAll() {
        return vendaProdutoRepository.findAll();
    }

    @Override
    public Optional<VendaProduto> findById(Integer id) {
        return vendaProdutoRepository.findById(id);
    }

    @Override
    public VendaProduto create(VendaProduto vendaProduto) {
        Produto produto = vendaProduto.getProduto();
        Estoque estoque = estoqueService.getEstoqueMenorValidade(produto);
        estoqueService.decrementaEstoque(estoque.getId(), vendaProduto.getQuatidade());
        return vendaProdutoRepository.save(vendaProduto);
    }

    @Override
    public void delete(VendaProduto vendaProduto) {
        vendaProdutoRepository.deleteById(vendaProduto.getId());
    }
}
