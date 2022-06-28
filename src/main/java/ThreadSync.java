package main.java;

import java.util.AbstractCollection;

public class ThreadSync extends Thread{
ABC1 abc1;
public ThreadSync(ABC1 abc1){
    this.abc1=abc1;
}

    @Override
    public void run() {
        abc1.method1();
        System.out.println("completed method1...");
    }


    public static void main(String[] args) {
        ABC1 abc11 = new ABC1();
        ThreadSync t1 = new ThreadSync(abc11);
       ThreadSync t2 = new ThreadSync(abc11);
        t1.start();
       t2.start();
    }
}

class ABC1 {
    public synchronized void method1(){
        System.out.println("Inside method1...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}