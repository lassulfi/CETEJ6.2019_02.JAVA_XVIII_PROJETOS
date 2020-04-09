/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EJBCalcularodaSimplesLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author lassulfi
 */
@Named(value = "jSFCalculadoraSimples")
@RequestScoped
public class JSFCalculadoraSimples {

    @EJB
    private EJBCalcularodaSimplesLocal eJBCalcularodaSimples;

    private int valor;
    
    /**
     * Creates a new instance of JSFCalculadoraSimples
     */
    public JSFCalculadoraSimples() {
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void dobrar() {
        this.valor = eJBCalcularodaSimples.dobrar(valor);
    }
}
