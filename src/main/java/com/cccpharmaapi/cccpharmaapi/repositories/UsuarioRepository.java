package com.cccpharmaapi.cccpharmaapi.repositories;

import com.cccpharmaapi.cccpharmaapi.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
