package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

public class Lote {

    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Estoque estoque;

    @ManyToOne
    private Venda venda;

    @Column
    private Integer quantidade;

    @Column
    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
