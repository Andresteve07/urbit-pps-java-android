/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosrxjava;

import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 *
 * @author andresteve07
 */
public class EjemplosRxJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Observable<String> obss = Observable.from(new String[]{"HOLA","como","EsTaS"});
        obss.map((String t) -> {
            String resultado = t.trim().toLowerCase().replace("o", "@");
            try {
                Thread.sleep(500);
                System.out.println("TRANSFORMADO: " +resultado);
            } catch (InterruptedException ex) {
                System.err.println("Interrumpido");
            }
            return resultado;
        }).map((String t) -> {
            Integer resultado = t.length();
            try {
                Thread.sleep(500);
                System.out.println("TRANSFORMADO: " + resultado);
            } catch (InterruptedException ex) {
                System.err.println("Interrumpido");
            }
            return resultado;
        }).filter(entero -> {
            return entero == 4;
        }).first()
            .subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("COMPLETADO");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.err.println("ERROR");
            }

            @Override
            public void onNext(Integer t) {
                System.out.println("RECIBIDO: " + t);
            }
        });
        
        try {
            // TODO code application logic here
            Observable<String> obs = Observable.just("HOLA");
            obs.subscribeOn(Schedulers.io())
                    .subscribe(cadena -> System.out.println(cadena),
                            t -> System.out.println("ERROR" + t.getMessage()),
                            () -> System.err.println("COMPLETO EN: " + Thread.currentThread().getName()));
            
            Completable comp = Completable.fromAction(new Action0() {
                @Override
                public void call() {
                    for(int i = 0; i < 5; i++){
                        try {
                            Thread.sleep(850);
                            System.out.println("PROCESANDO " + i);
                            if(i == 3){
                                throw new RuntimeException("ERROR HARCODEADO!");
                            }
                        } catch (InterruptedException ex) {
                            System.err.println("Interrumpido");
                        }
                    }
                }
            });
            comp.subscribeOn(Schedulers.computation()).subscribe(new CompletableSubscriber() {
                @Override
                public void onCompleted() {
                    System.out.println("COMPLETO JOYA!" + Thread.currentThread().getName());
                }
                
                @Override
                public void onError(Throwable thrwbl) {
                    System.err.println("ERROR" + thrwbl.getMessage());
                }
                
                @Override
                public void onSubscribe(Subscription s) {
                    System.out.println("SUBSCRIPCION REALIZADA  " + Thread.currentThread().getName());
                }
            });
            
            Thread.sleep(9000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EjemplosRxJava.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
