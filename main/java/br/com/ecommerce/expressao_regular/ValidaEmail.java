/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ecommerce.expressao_regular;

/**
 *
 * @author marco
 */
public abstract class ValidaEmail {
    
    private static final String REGEX = "([\\w-\\.])+@([a-zA-Z])+(\\.([a-zA-Z])+){1,}";
    
    public static boolean emailValido(String email){
        return email.matches(REGEX);
    }

}
