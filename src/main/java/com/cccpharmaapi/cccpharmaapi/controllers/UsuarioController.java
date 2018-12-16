package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Usuario;
import com.cccpharmaapi.cccpharmaapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://ccc-pharma.herokuapp.com")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.POST, value="/")
    @ResponseStatus(HttpStatus.CREATED)
       public Usuario addUsuario(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }

    @RequestMapping(method = RequestMethod.GET, value="/")
    @Role("ADMIN")
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    @Role("ADMIN")
    public Usuario findById(@PathVariable("id") Integer id) {
        Usuario res = null;
        Optional<Usuario> costumer = usuarioService.findById(id);
        if (costumer.isPresent()) {
            res = costumer.get();
        }

        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}/password")
    @Role("ADMIN")
    public Map<String, String> getPassword(@PathVariable("id") Integer id) {
        Map<String, String> res = null;
        Usuario usuario = findById(id);

        if (usuario != null) {
            res.put(usuario.getUsername(), usuario.getPassword());
        }

        return res;
    }
}
