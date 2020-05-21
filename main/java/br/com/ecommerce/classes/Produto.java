/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.classes;

import br.com.ecommerce.enumeracoes.EstadoProduto;
import java.util.Objects;

/**
 *
 * @author marco
 */
public class Produto {

    private Integer id_produto;
    private Integer id_foreign;
    private String nome;
    private String descricao;
    private String categoria;
    private Double preco;
    private EstadoProduto situacao;

    public Produto() {
    }

    public Produto(String nome, String descricao, String categoria, Double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
    }
    
    public Produto(String nome, String categoria, Double preco, EstadoProduto situacao) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        if (!Objects.equals(this.preco, other.preco)) {
            return false;
        }
        return true;
    }

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public Integer getId_foreign() {
        return id_foreign;
    }

    public void setId_foreign(Integer id_foreign) {
        this.id_foreign = id_foreign;
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

    public EstadoProduto getSituacao() {
        return situacao;
    }

    public void setSituacao(EstadoProduto situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return "Produto{" + "id_produto=" + id_produto + ", id_foreign=" + id_foreign + ", nome=" + nome + ", categoria=" + categoria + ", preco=" + preco + ", situacao=" + situacao + '}';
    }

}
