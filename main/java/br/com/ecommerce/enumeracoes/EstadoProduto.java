/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.enumeracoes;

/**
 *
 * @author marco
 */
public enum EstadoProduto {
    
    ESTOQUE(1, "Produto em estoque"),
    INDISPONIVEL(2, "Produto indisponível/ em carrinho"),
    VENDIDO(3, "Produto vendido"),
    FORA_ESTOQUE(4, "Produto fora de estoque");
    
    private int type;
    private String descricao;

    private EstadoProduto(int type, String descricao) {
        this.type = type;
        this.descricao = descricao; 
    }

    public int getType() {
        return type;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
