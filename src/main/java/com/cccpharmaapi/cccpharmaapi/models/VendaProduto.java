package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

@Entity
@Table(name = "vendaProdutos")
public class VendaProduto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "vendaId_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn( name = "codigo_id")
    private Produto produto;

    @Column
    private int quatidade;

    @Column
    private double subTotal;

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(int quatidade) {
        this.quatidade = quatidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
