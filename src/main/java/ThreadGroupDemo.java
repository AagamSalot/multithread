package main.java;

public class ThreadGroupDemo implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ThreadGroupDemo threadGroupDemo = new ThreadGroupDemo();
        ThreadGroup tg1 = new ThreadGroup("parent grp");
        Thread t1 = new Thread(tg1,threadGroupDemo,"t1");
        Thread t2 = new Thread(tg1,threadGroupDemo,"t2");
        Thread t3 = new Thread(tg1,threadGroupDemo,"t3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Thread Group Name: "+tg1.getName());
//        tg1.destroy();
        tg1.list();

    }
}
