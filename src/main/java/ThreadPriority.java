package main.java;

public class ThreadPriority implements Runnable{
    public static void main(String[] args) {

        ThreadPriority th1 = new ThreadPriority();
        Thread t1 = new Thread(th1);
        t1.setPriority(4);
        ThreadPriority th2 = new ThreadPriority();
        Thread t2 = new Thread(th1);
        t2.setPriority(10);
        t1.start();
        t2.start();
    }

    public void run(){
            System.out.println("Thread..."+Thread.currentThread().getName());
    }
}
