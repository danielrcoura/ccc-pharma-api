package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

public class Lote {

    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne
    private Estoque estoque;

    @Column
    private int quantidade;

    public int getId() {
        return id;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
