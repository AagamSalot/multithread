package main.java;

public class ThreadLocalDemo implements Runnable{

    ThreadLocal<Integer> thlocal = new ThreadLocal<Integer>();
//    int i =9;

    @Override
    public void run() {
        thlocal.set(12+(int)(Math.random()* 50D));
//        i = 12+(int)(Math.random()* 50D);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Th local value="+thlocal.get());
//        System.out.println("Normal value="+i);
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        Thread t1 = new Thread(threadLocalDemo);
        Thread t2 = new Thread(threadLocalDemo);
        t1.start();
        t2.start();
    }
}
