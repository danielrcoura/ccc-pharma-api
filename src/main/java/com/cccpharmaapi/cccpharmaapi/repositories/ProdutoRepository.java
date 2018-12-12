package com.cccpharmaapi.cccpharmaapi.repositories;

import com.cccpharmaapi.cccpharmaapi.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
