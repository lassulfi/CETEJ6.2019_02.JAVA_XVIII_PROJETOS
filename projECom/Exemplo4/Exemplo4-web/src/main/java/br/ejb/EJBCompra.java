/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ejb;

import br.data.entity.ItensCompra;
import br.data.entity.Produto;
import java.util.ArrayList;
import javax.ejb.Stateful;

/**
 *
 * @author lassulfi
 */
@Stateful
public class EJBCompra {

    private ArrayList<ItensCompra> listaDeCompras;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public EJBCompra() {
        listaDeCompras = new ArrayList<>();
    }
   
    public void add(Produto produto) {
        boolean existente = false;
        
        for(ItensCompra itensCompra : listaDeCompras) {
            if(itensCompra.getProduto().getCodigo() == produto.getCodigo()) {
                 itensCompra.setQuantidade(itensCompra.getQuantidade() + 1);
                 existente = true;
            }
        }
        if(!existente) {
            listaDeCompras.add(new ItensCompra(produto, 1));
        }
    }
    
    public ArrayList<ItensCompra> getAll() {
        return listaDeCompras;
    }
    
    public void fecharPedido() {
        //metodo de pagamento...
        listaDeCompras = new ArrayList<>();
    }
}
