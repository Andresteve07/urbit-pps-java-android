/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anonimas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andresteve07
 */
public class Anonimas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Integer miEntero = 12;
        Animal miAnimal = new Animal("Perro") {
            @Override
            void hace() {
                Integer otro = miEntero;
                System.out.println("GUAU");
            }
        };
        miAnimal.hace();
        
        
    }
    
   
    
}
