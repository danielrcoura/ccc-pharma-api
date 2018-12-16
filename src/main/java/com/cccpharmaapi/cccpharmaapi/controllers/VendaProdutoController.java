package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.VendaProduto;
import com.cccpharmaapi.cccpharmaapi.services.VendaProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://ccc-pharma.herokuapp.com")
@RequestMapping("/vendaprodutos")
public class VendaProdutoController {

    @Autowired
    private VendaProdutoService vendaProdutoService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @Role("ADMIN")
    public List<VendaProduto> getAllVendas() {
        return vendaProdutoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @Role("ADMIN")
    public VendaProduto getVenda(@PathVariable("id") Integer id) {
        return vendaProdutoService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    @Role("ADMIN")
    public VendaProduto putVenda(@RequestBody VendaProduto vendaProduto) {
            return vendaProdutoService.create(vendaProduto);
    }
}
