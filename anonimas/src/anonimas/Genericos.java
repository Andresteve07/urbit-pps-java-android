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
public class Genericos {
    public static void main(String[] args) {
        BolsaConObject bolsa = new BolsaConObject(4);
        Gato tom = new Gato("Tom");
        Gato michi = new Gato("Michi");
        Gato garf = new Gato("Garfield");
        String cadena = "cadena";
        bolsa.add(tom);
        bolsa.add(garf);
        bolsa.add(michi);
        bolsa.add(cadena);
        /*
        for(Object objeto : bolsa){
            ((Gato)objeto).hace();
        }
        */
        
        BolsaGenerica<Gato> bolsaGen = new BolsaGenerica(4);
        
        bolsaGen.add(tom);
        bolsaGen.add(michi);
        bolsaGen.add(garf);
        //bolsaGen.add(cadena);

        for(Gato gato: bolsaGen){
            gato.hace();
        }
       
        BolsaGenerica<String> bolsaStrings = new BolsaGenerica<>(3);
        Perro pipo = new Perro("Pipo");
        BolsaAnimales<Animal> bolsaAnim = new BolsaAnimales<>(2);
        bolsaAnim.add(tom);
        bolsaAnim.add(pipo);
        
    }
}
