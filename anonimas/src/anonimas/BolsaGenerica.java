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
public class BolsaGenerica<T> implements Iterable<T>{
    private final List<T> lista = new ArrayList();
    private int tope;

    public BolsaGenerica(int tope) {
        this.tope = tope;
    }
    
    public void add(T objeto ) {
        if (lista.size()<=tope) {
            lista.add(objeto);
        }else {
            throw new RuntimeException("no caben mas");
        }
    }
    
    @Override
    public Iterator<T> iterator() {
        return lista.iterator();
    }
    
    
}
