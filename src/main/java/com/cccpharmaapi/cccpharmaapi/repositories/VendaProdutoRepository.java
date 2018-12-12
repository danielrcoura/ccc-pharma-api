package com.cccpharmaapi.cccpharmaapi.repositories;

import com.cccpharmaapi.cccpharmaapi.models.VendaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaProdutoRepository extends JpaRepository<VendaProduto, Integer> {

}
