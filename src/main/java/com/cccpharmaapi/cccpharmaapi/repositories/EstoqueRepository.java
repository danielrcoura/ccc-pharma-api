package com.cccpharmaapi.cccpharmaapi.repositories;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{

    @Query(value = "SELECT * FROM estoques WHERE codigo_id =:codigo ORDER BY validade ASC;", nativeQuery = true)
    Optional<List<Estoque>> findEstoqueMenorValidade(@Param("codigo") int codigo);
}
