/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import javax.ejb.Local;

/**
 *
 * @author lassulfi
 */
@Local
public interface EJBCalcularodaSimplesLocal {
    public int dobrar(int valor);
}
