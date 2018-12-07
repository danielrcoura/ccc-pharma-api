package com.cccpharmaapi.cccpharmaapi.services;

import com.cccpharmaapi.cccpharmaapi.models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario create(Usuario usuario);

    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);
}
