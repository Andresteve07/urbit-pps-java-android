/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplosrxjava;

import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 *
 * @author andresteve07
 */
public class Intro {
    public static void main(String[] args) {
        try {
            Observable<Integer> emisorInt = Observable.range(2, 30);
            
            Subscription subcripcion = emisorInt
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Subscriber<Integer>() {
                        @Override
                        public void onCompleted() {
                            System.out.println("COMPETADO!");
                        }
                        
                        @Override
                        public void onError(Throwable thrwbl) {
                            System.err.println("ERROR: " + thrwbl.getMessage());
                        }
                        
                        @Override
                        public void onNext(Integer t) {
                            System.out.println("RECIBIDO: " + t + " EN :" + Thread.currentThread().getName());
                        }
                    });
            
            Thread.sleep(2000L);
            System.out.println("TERMINADO EL MAIN!");
        } catch (InterruptedException ex) {
            Logger.getLogger(Intro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
