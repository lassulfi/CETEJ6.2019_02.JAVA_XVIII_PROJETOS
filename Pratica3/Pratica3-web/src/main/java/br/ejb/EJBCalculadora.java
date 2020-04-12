/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import br.rems.ICalculadora;
import javax.ejb.Stateless;

/**
 *
 * @author lassulfi
 */
@Stateless
public class EJBCalculadora implements ICalculadora {

    @Override
    public int fatorial(int valor) {
        if (valor == 1) return 1;
        return valor * fatorial(valor - 1);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
