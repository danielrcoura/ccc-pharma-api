package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;

@Entity
@Table(name = "vendaProdutos")
public class VendaProduto {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn( name = "vendaId_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn( name = "codigo_id")
    private Produto produto;

    @Column
    private int quantidade;

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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
