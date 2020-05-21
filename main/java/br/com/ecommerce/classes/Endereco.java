/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.classes;

import java.util.Objects;

/**
 *
 * @author marco
 */
public class Endereco {

    private Integer id_foreign;
    private Integer id_endereco;
    private String rua;
    private String cidade;
    private String cep;
    private String complemento;
    private String numero;

    public Endereco() {
    }

    public Endereco(String rua, String cidade, String cep, String numero) {
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id_endereco);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.id_endereco, other.id_endereco)) {
            return false;
        }
        return true;
    }
    
    public Integer getId_foreign() {
        return id_foreign;
    }

    public void setId_foreign(Integer id_foreign) {
        this.id_foreign = id_foreign;
    }

    public Integer getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Integer id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id_foreign=" + id_foreign + ", id_endereco=" + id_endereco + ", rua=" + rua + ", cidade=" + cidade + ", cep=" + cep + ", complemento=" + complemento + ", numero=" + numero + '}';
    }
}
