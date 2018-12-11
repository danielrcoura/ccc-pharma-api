package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Venda;
import com.cccpharmaapi.cccpharmaapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;

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
        return vendaRepository.save(venda);
    }

    @Override
    public Venda update(Venda venda) {
        return vendaRepository.saveAndFlush(venda);
    }

    @Override
    public void delete(Venda venda) {
        vendaRepository.deleteById(venda.getId());
    }
}
