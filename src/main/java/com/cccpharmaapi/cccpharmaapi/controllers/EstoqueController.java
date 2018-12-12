package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Estoque;
import com.cccpharmaapi.cccpharmaapi.services.EstoqueService;
import com.cccpharmaapi.cccpharmaapi.services.EstoqueServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    private EstoqueService estoqueService = new EstoqueServiceImpl();

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
