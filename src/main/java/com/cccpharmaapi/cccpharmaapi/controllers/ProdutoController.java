package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Produto;
import com.cccpharmaapi.cccpharmaapi.services.ProdutoService;
import com.cccpharmaapi.cccpharmaapi.services.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Produto findById(@PathVariable("id") Integer id){
        Produto res = null;
        Optional<Produto> produto = produtoService.findById(id);

        if (produto.isPresent()) res = produto.get();

        return res;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto addProduto(Produto produto){
        return produtoService.create(produto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/produtos/delete")
    public void removeProduto(Produto produto){
        produtoService.delete(produto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/produtos/update")
    public Produto updateProduto(Produto produto) {
        return produtoService.update(produto);
    }
}
