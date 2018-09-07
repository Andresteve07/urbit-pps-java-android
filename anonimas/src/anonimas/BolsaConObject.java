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
public class BolsaConObject implements Iterable{
    private final List lista= new ArrayList();
    private final int tope;

    public BolsaConObject(int tope) {
        this.tope = tope;
    }
    public void add(Object objeto ) {
        if (lista.size()<=tope) {
            lista.add(objeto);
        }else {
            throw new RuntimeException("no caben mas");
        }
    }

    @Override
    public Iterator iterator() {
        return lista.iterator();
    }
}
