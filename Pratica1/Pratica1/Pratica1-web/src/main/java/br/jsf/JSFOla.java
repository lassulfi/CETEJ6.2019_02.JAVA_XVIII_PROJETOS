/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.jsf;

import br.ejb.EJBOla;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author lassulfi
 */
@Named(value = "jSFOla")
@RequestScoped
public class JSFOla {

    @EJB
    private EJBOla eJBOla;

    private String mensagem;
    
    /**
     * Creates a new instance of JSFOla
     */
    public JSFOla() {
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public void chamarEjb() {
        this.mensagem = eJBOla.helloWorld();
    }
}
