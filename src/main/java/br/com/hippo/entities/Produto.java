package br.com.hippo.entities;

import java.math.BigDecimal;

public class Produto {

    private Long id;
    private String nome;
    private String descproduto;
    private BigDecimal preco;
    private double descontopromo;
    private Categoria categoria;
    private boolean produtoativo;
    private int iduser;
    private int qtdminima;
    private String imagem;

    public Produto(Long id, String nome, BigDecimal preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    // Construtor para detalhes do Produto
    public Produto(Long id, String nome, String descproduto, BigDecimal preco,
                   double descontopromo, Categoria categoria, boolean produtoativo,
                   int iduser, int qtdminima, String imagem) {

        this.id = id;
        this.nome = nome;
        this.descproduto = descproduto;
        this.preco = preco;
        this.descontopromo = descontopromo;
        this.categoria = categoria;
        this.produtoativo = produtoativo;
        this.iduser = iduser;
        this.qtdminima = qtdminima;
        this.imagem = imagem;

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescproduto() {
        return descproduto;
    }

    public void setDescproduto(String descproduto) {
        this.descproduto = descproduto;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public double getDescontopromo() {
        return descontopromo;
    }

    public void setDescontopromo(double descontopromo) {
        this.descontopromo = descontopromo;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isProdutoativo() {
        return produtoativo;
    }

    public void setProdutoativo(boolean produtoativo) {
        this.produtoativo = produtoativo;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getQtdminima() {
        return qtdminima;
    }

    public void setQtdminima(int qtdminima) {
        this.qtdminima = qtdminima;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}