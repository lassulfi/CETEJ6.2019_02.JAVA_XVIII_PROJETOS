/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import br.data.entity.Produto;
import java.util.ArrayList;

/**
 *
 * @author lassulfi
 */
public class CrudProduto extends AbstractFacade<Produto> {

    private static ArrayList<Produto> list;
    
    @Override
    protected ArrayList<Produto> getEntityManager() {
        list = new ArrayList();
        list.add(new Produto(1, "notebook"));
        list.add(new Produto(2, "mouse"));
        list.add(new Produto(3, "monitor"));
        list.add(new Produto(4, "teclado"));
        list.add(new Produto(5, "ssd"));
        
        return list;
    }
    
}
