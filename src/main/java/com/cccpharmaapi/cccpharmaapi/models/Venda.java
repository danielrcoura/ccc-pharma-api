package com.cccpharmaapi.cccpharmaapi.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendaId;

    @Column
    private Double valorTotal;

    @OneToMany(mappedBy = "venda")
    private List<VendaProduto> vendas;

    @Column
    private Date data;

    public Integer getVendaId() {
        return vendaId;
    }

    public void setVendaId(Integer vendaId) {
        this.vendaId = vendaId;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<VendaProduto> getVendas() {
        return vendas;
    }

    public void setVendas(List<VendaProduto> vendas) {
        this.vendas = vendas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
