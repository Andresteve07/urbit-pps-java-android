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
public class Taladro {
    private int maxVueltas;

    public Taladro(int maxVueltas) {
        this.maxVueltas = maxVueltas;
    }

    public int vueltasRestantes() {
        return maxVueltas;
    }
    
    public void usar(int vueltasRealizadas){
        if(this.maxVueltas<=0){
            System.out.println("TALADRO ROTO");
            return;
        }
        this.maxVueltas-=vueltasRealizadas;
        System.out.println("QUEDAN " + this.maxVueltas + " VUELTAS.");
    }
}
