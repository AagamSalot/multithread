package main.java;

public class ShutdownHookT extends Thread{

    public void run(){
        try {
            System.out.println("Shutdown called..");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("inside main...");
        Runtime.getRuntime().addShutdownHook(new ShutdownHookT());
           System.exit(0);
        System.out.println("done.......");
        Thread t1 =new Thread(){
            @Override
            public void run() {
                super.run();
            }
        };
        t1.start();
    }
}
