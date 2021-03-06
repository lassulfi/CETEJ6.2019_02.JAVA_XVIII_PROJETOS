/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.rems.ICalculadora;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author lassulfi
 */
@Named(value = "jSFCalculadora")
@RequestScoped
public class JSFCalculadora {

    @EJB
    private ICalculadora eJBCalculadora;

    private int valor;
    
    /**
     * Creates a new instance of JSFCalculadora
     */
    public JSFCalculadora() {
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void fatorial() {
        this.valor = eJBCalculadora.fatorial(valor);
    }
}
