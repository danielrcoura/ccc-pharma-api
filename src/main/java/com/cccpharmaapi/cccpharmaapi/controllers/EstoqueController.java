package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Estoque> getEstoqueAll() {
        return estoqueService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Estoque getEstoqueById(@PathVariable("id") Integer id) {
        return estoqueService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    @Role("ADMIN")
    public Estoque createEstoque(@RequestBody Estoque estoque) {
        return estoqueService.create(estoque);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    @Role("ADMIN")
    public Estoque updateEstoque(@RequestBody Estoque estoque) { return estoqueService.update(estoque); }
}
