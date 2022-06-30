package main.java;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntDemo {
    public static void main(String[] args) throws InterruptedException {
            TestAtomic testAtomic = new TestAtomic();
            Thread t1 = new Thread(testAtomic,"t1");
            Thread t2 = new Thread(testAtomic,"t2");
            Thread t3 = new Thread(testAtomic,"t3");
        t1.start();

        t2.start();
//        t1.join();
//        t2.join();
        t3.start();
//        t3.join();
//
//        t2.join();
//        t3.join();
        Thread.sleep(6000);
        System.out.println("final value= "+testAtomic.getCounter());
    }
}

class TestAtomic implements Runnable{

    private AtomicInteger count = new AtomicInteger();
//    int counti = 0;

     int getCounter(){
       return  count.get();
    }

    public void increment(){
        count.incrementAndGet();
    }
    @Override
    public void run() {
            for (int i = 0; i < 4; i++) {
                increment();
//                counti++;
            }
        }
    }

