package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

@Entity
public class Produto {

    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column
    private String nome;

    @Column
    private String fabricante;

    @Column
    private String categoria;

    @Column
    private Double preco;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
