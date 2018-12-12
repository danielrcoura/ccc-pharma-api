package com.cccpharmaapi.cccpharmaapi.services;

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
        return vendaProdutoRepository.save(vendaProduto);
    }

    @Override
    public VendaProduto update(VendaProduto vendaProduto) {
        return vendaProdutoRepository.saveAndFlush(vendaProduto);
    }

    @Override
    public void delete(VendaProduto vendaProduto) {
        vendaProdutoRepository.deleteById(vendaProduto.getId());
    }
}
