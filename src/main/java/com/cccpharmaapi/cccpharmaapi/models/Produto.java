package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column
    private String codigo;

    @Column
    private String nome;

    @Column
    private String categoria;

    @Column
    private Double preco;

    @Column
    private String fabricante;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
