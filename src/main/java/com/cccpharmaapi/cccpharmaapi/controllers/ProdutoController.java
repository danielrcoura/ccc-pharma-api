package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Produto;
import com.cccpharmaapi.cccpharmaapi.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(method = RequestMethod.GET, value = "/")
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

    @RequestMapping(method = RequestMethod.POST, value = "/")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto addProduto(@RequestBody Produto produto){
        return produtoService.create(produto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    public void removeProduto(@RequestBody Produto produto){
        produtoService.delete(produto.getId());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/")
    public Produto updateProduto(@RequestBody Produto produto) {
        return produtoService.update(produto);
    }
}
