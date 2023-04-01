package com.gamevault.gamevault.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Products {

    @Id
    @SequenceGenerator(name = "PRODUCT_ID_SEQ", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_ID_SEQ")
    private Integer id;

    @Column(name = "PRODUTO_NOME")
    private String product_nome;

    @Column(name = "CATEGORIA")
    private String categoria;

    @Column(name = "preco")
    private String preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct_nome() {
        return product_nome;
    }

    public void setProduct_nome(String product_nome) {
        this.product_nome = product_nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
