package com.cccpharmaapi.cccpharmaapi.controllers;

import com.cccpharmaapi.cccpharmaapi.models.Produto;
import com.cccpharmaapi.cccpharmaapi.services.ProdutoService;
import com.cccpharmaapi.cccpharmaapi.services.ProdutoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService = new ProdutoServiceImpl();

    @RequestMapping(method = RequestMethod.GET, value = "/produtos/all")
    @ResponseBody
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/produtos/{id}")
    @ResponseBody
    public Produto findById(@PathVariable("id") Integer id){
        Produto res = null;
        Optional<Produto> produto = produtoService.findById(id);

        if (produto.isPresent()) res = produto.get();

        return res;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/produtos/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Produto addProduto(Produto produto){
        return produtoService.create(produto);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/produtos/delete")
    @ResponseBody
    public void removeProduto(Produto produto){
        produtoService.delete(produto);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/produtos/update")
    @ResponseBody
    public Produto updateProduto(Produto produto) {
        return produtoService.update(produto);
    }
}
