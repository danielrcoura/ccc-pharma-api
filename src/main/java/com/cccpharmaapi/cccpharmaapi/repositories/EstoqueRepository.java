package com.cccpharmaapi.cccpharmaapi.repositories;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{

    @Query(value = "SELECT * FROM estoques WHERE codigo_id = :codigo ORDER BY validade ASC;", nativeQuery = true)
    List<Estoque> findEstoqueMenorValidade(@PathVariable("codigo") int codigo);
}
