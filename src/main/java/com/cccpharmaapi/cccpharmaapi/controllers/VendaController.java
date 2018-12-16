package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Venda;
import com.cccpharmaapi.cccpharmaapi.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @Role("ADMIN")
    public List<Venda> getAllVendas() {
        return vendaService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    @Role("ADMIN")
    public Venda getVenda(@PathVariable("id") Integer id) {
        return vendaService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    @Role("ADMIN")
    public Venda postVenda(@RequestBody Venda venda) {
        return vendaService.create(venda);
    }
}
