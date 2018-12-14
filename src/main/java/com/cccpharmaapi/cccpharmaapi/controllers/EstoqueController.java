package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.services.EstoqueService;
import com.cccpharmaapi.cccpharmaapi.services.EstoqueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @RequestMapping(method = RequestMethod.GET, value = "/estoque/all")
    @ResponseBody
    public List<Estoque> getAllVendas() {
        return estoqueService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/estoque/{id}")
    @ResponseBody
    public Estoque getVenda(@PathVariable("id") Integer id) {
        return estoqueService.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/estoque/add")
    @ResponseBody
    public Estoque createEstoque(Estoque estoque) {
        return estoqueService.create(estoque);
    }
}
