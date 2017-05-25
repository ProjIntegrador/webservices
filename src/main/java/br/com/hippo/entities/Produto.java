package br.com.hippo.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Produto implements Serializable {

    @Id
    @GeneratedValue
    private Long idProduto;
    private String nomeProduto;
    private String descProduto;
    private BigDecimal precProduto;
    private double descontoPromocao;
    @ManyToOne(fetch=FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="idCategoria")
    private Categoria categoria;
    private boolean ativoProduto;

    public Produto() {}

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public BigDecimal getPrecProduto() {
        return precProduto;
    }

    public void setPrecProduto(BigDecimal precProduto) {
        this.precProduto = precProduto;
    }

    public double getDescontoPromocao() {
        return descontoPromocao;
    }

    public void setDescontoPromocao(double descontoPromocao) {
        this.descontoPromocao = descontoPromocao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivoProduto() {
        return ativoProduto;
    }

    public void setAtivoProduto(boolean ativoProduto) {
        this.ativoProduto = ativoProduto;
    }

}