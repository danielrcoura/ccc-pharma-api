package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Venda;
import com.cccpharmaapi.cccpharmaapi.services.VendaService;
import com.cccpharmaapi.cccpharmaapi.services.VendaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaController {
    private VendaService vendaService = new VendaServiceImpl();

    @RequestMapping(method = RequestMethod.GET, value = "/vendas/all")
    @ResponseBody
    public List<Venda> getAllVendas() {
        return vendaService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vendas/{id}")
    @ResponseBody
    public Venda getVenda(@PathVariable("id") Integer id) {
        return vendaService.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/vendas/add")
    @ResponseBody
    public Venda putVenda(Venda venda) {
        return vendaService.create(venda);
    }
}
