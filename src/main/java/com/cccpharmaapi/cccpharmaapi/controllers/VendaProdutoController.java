package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Venda;
import com.cccpharmaapi.cccpharmaapi.models.VendaProduto;
import com.cccpharmaapi.cccpharmaapi.services.VendaProdutoService;
import com.cccpharmaapi.cccpharmaapi.services.VendaProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendaproduto")
public class VendaProdutoController {

    @Autowired
    private VendaProdutoService vendaProdutoService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<VendaProduto> getAllVendas() {
        return vendaProdutoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public VendaProduto getVenda(@PathVariable("id") Integer id) {
        return vendaProdutoService.findById(id);
    }
}
