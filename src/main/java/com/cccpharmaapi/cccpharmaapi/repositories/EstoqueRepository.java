package com.cccpharmaapi.cccpharmaapi.repositories;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{

}