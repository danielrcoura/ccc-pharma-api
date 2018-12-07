package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

@Entity
public class Produto {

    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String codigo;

    @Column
    private String nome;

    @Column
    private String fabricante;

    @Column
    private String categoria;

    @Column
    private Double preco;

    public Integer getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
