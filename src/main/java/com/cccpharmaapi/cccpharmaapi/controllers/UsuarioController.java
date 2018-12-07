package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Usuario;
import com.cccpharmaapi.cccpharmaapi.services.UsuarioService;
import com.cccpharmaapi.cccpharmaapi.services.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService = new UsuarioServiceImpl();

    @RequestMapping(method = RequestMethod.POST, value="/usuarios/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }

    @RequestMapping(method = RequestMethod.GET, value="/usuarios/all")
    @ResponseBody
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value="/usuarios/{id}")
    @ResponseBody
    public Optional<Usuario> findById(@PathVariable("id") Integer id) {
        return usuarioService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value="/usuarios/{id}/password")
    @ResponseBody
    public Map<String, String> getPassword(@PathVariable("id") Integer id) {
        Map<String, String> res = null;
        Optional<Usuario> costumer = findById(id);

        if (costumer.isPresent()) {
            Usuario usuario = costumer.get();
            res.put(usuario.getLogin(), usuario.getPassword());
        }

        return res;
    }
}
