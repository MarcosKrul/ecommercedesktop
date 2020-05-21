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
public enum TipoUsuario {
    
    USUARIO_CONSUMIDOR(1), 
    USUARIO_GERENTE(2);
    
    private int type;

    private TipoUsuario(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
