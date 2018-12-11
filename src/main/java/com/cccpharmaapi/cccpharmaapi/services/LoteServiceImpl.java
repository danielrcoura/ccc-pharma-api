package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Lote;
import com.cccpharmaapi.cccpharmaapi.repositories.LoteRepository;

import java.util.List;
import java.util.Optional;

public class LoteServiceImpl implements LoteService{
    @Override
    public List<Lote> findAll() {
        return LoteRepository.findAll();
    }

    @Override
    public Optional<Lote> findById(Integer id) {
        return LoteRepository.findById(id);
    }

    @Override
    public Lote create(Lote lote) {
        return LoteRepository.save(lote);
    }

    @Override
    public Lote update(Lote lote) {
        return LoteRepository.saveAndFlush(lote);
    }

    @Override
    public void delete(Lote lote) {
        LoteRepository.deleteById(lote.getId());
    }
}
