package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Venda;
import com.cccpharmaapi.cccpharmaapi.models.VendaProduto;
import com.cccpharmaapi.cccpharmaapi.services.VendaProdutoService;
import com.cccpharmaapi.cccpharmaapi.services.VendaProdutoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/vendaproduto")
public class VendaProdutoController {

    private VendaProdutoService vendaProdutoService = new VendaProdutoServiceImpl();

    @RequestMapping(method = RequestMethod.GET, value = "/vendaproduto/all")
    @ResponseBody
    public List<VendaProduto> getAllVendas() {
        return vendaProdutoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vendaproduto/{id}")
    @ResponseBody
    public VendaProduto getVenda(@PathVariable("id") Integer id) {
        return vendaProdutoService.findById(id);
    }
}
