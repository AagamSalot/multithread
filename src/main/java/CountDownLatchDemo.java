package main.java;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        ClassThread classThread = new ClassThread(countDownLatch);
        ClassThread classThread1 = new ClassThread(countDownLatch);
        ClassThread classThread2 = new ClassThread(countDownLatch);
        ClassThread classThread3 = new ClassThread(countDownLatch);

        classThread.start();
        classThread1.start();
        classThread2.start();
        classThread3.start();

        try {
            countDownLatch.await();
            System.out.println("Main started.....");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

  class ClassThread extends Thread{
    CountDownLatch countDownLatch;
    public ClassThread(CountDownLatch countDownLatch){
            this.countDownLatch=countDownLatch;
        }

    @Override
      public void run() {
        System.out.println("Thread started...");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countDownLatch.countDown();
    }
  }
