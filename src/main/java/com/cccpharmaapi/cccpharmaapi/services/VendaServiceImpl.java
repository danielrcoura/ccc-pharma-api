package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Venda;
import com.cccpharmaapi.cccpharmaapi.repositories.VendaRepository;

import java.util.List;
import java.util.Optional;

public class VendaServiceImpl implements VendaService {
    @Override
    public List<Venda> findAll() {
        return VendaRepository.findAll();
    }

    @Override
    public Optional<Venda> findById(Integer id) {
        return VendaRepository.findById(id);
    }

    @Override
    public Venda create(Venda venda) {
        return VendaRepository.save(venda);
    }

    @Override
    public Venda update(Venda venda) {
        return VendaRepository.saveAndFlush(venda);
    }

    @Override
    public void delete(Venda venda) {
        VendaRepository.deleteById(venda.getId());
    }
}
