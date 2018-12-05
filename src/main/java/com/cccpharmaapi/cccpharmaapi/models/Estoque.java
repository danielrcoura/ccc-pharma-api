package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;
import java.util.Date;

public class Estoque {

    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Produto produto;

    @Column
    private Date validade;

    @Column
    private int quantidade;

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
