/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anonimas;

/**
 *
 * @author andresteve07
 */
public class Gato extends Animal{

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    void hace() {
        System.out.println("MIAU");
    }
    
}
