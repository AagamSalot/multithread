package main.java;

public class ThreadSyncStatic extends Thread{
    @Override
    public void run() {
        ThreadSyncStatic.abc();
    }

    public static synchronized void abc(){
        System.out.println("Static sync....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Static sync completed....");
    }

    public static void main(String[] args) {
        ThreadSyncStatic threadSyncStatic = new ThreadSyncStatic();
        ThreadSyncStatic threadSyncStatic1 = new ThreadSyncStatic();
        threadSyncStatic.start();
        threadSyncStatic1.start();
    }
}


