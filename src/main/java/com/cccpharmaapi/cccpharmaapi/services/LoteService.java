package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Lote;

import java.util.List;
import java.util.Optional;

public interface LoteService {

    List<Lote> findAll();

    Optional<Lote> findById(Integer id);

    Lote create(Lote lote);

    Lote update(Lote lote);

    void delete(Lote lote);
}
