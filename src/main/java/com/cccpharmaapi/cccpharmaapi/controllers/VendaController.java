package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Venda;
import com.cccpharmaapi.cccpharmaapi.services.VendaService;
import com.cccpharmaapi.cccpharmaapi.services.VendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Venda> getAllVendas() {
        return vendaService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Venda getVenda(@PathVariable("id") Integer id) {
        return vendaService.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/add")
    public Venda putVenda(Venda venda) {
        return vendaService.create(venda);
    }
}
