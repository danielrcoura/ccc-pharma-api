package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

@Entity
public class Venda {

    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Usuario comprador;

    @Column
    private Double valor;

    public Integer getId() {
        return id;
    }

    public Usuario getComprador() {
        return comprador;
    }

    public void setComprador(Usuario comprador) {
        this.comprador = comprador;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
