/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rems;

import javax.ejb.Remote;

/**
 *
 * @author lassulfi
 */
@Remote
public interface ICalculadora {
    public int fatorial(int valor);
}
