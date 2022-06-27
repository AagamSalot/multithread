package main.java;

import org.omg.Messaging.SyncScopeHelper;

import javax.sound.midi.Soundbank;

public class TestIt implements  Runnable{
public static Thread th1;
    public static void main(String[] args) {
//        System.out.println("hello");
        TestIt t1 = new TestIt();
        th1 = new Thread(t1) ;
        System.out.println("hello---"+th1.getState());
        th1.start();


        System.out.println("hello---"+th1.getState());
    }

    @Override
    public void run() {
        try {

            Thread.sleep(500);
            System.out.println("hello---"+th1.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
