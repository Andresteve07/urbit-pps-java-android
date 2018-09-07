/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anonimas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author andresteve07
 */
public class BolsaAnimales<Q extends Animal> implements Iterable<Q> {

    private final List<Q> lista = new ArrayList();
    private int tope;

    public BolsaAnimales(int tope) {
        this.tope = tope;
    }
    
    public void add(Q objeto ) {
        if (lista.size()<=tope) {
            lista.add(objeto);
        }else {
            throw new RuntimeException("no caben mas");
        }
    }
    @Override
    public Iterator<Q> iterator() {
        return lista.iterator();
    }
    
}
