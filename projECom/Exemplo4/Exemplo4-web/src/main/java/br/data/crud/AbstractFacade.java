/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.crud;

import java.util.ArrayList;

/**
 *
 * @author lassulfi
 * @param <T>
 */
public abstract class AbstractFacade<T> {
    
    private ArrayList<T> list;
       
    protected abstract ArrayList<T> getEntityManager();
    
    public AbstractFacade() {
        list = getEntityManager();
    }
    
    public void persist(T object) {
        list.add(object);
    }
    
    public ArrayList<T> getAll() {
        return list;
    }
}
