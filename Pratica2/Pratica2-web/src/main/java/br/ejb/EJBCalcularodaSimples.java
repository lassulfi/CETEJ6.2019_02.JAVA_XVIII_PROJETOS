/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author lassulfi
 */
@Stateless
public class EJBCalcularodaSimples implements EJBCalcularodaSimplesLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public int dobrar(int valor) {
        return valor + valor;
    }
}
