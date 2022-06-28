package main.java;

public class InterThreadComm {

    int amount=100;
    public synchronized void method1(int amount){
        if(amount>this.amount){
            try {
                System.out.println("wait starts....");
                wait();
                System.out.println("wait completed....");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void method2(int amount) {
       this.amount+=amount;
       notify();
    }

    public static void main(String[] args) {
        InterThreadComm interThreadComm = new InterThreadComm();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                interThreadComm.method1(1000);
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                interThreadComm.method2(1000);
            }
        };
        t1.start();
        t2.start();
    }
}

