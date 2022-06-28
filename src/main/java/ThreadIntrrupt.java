package main.java;

public class ThreadIntrrupt extends Thread{
    @Override
    public void run() {
        System.out.println("Thread started....");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
               //throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
      ThreadIntrrupt threadIntrrupt = new ThreadIntrrupt();
      threadIntrrupt.start();
      threadIntrrupt.interrupt();
      System.out.println(threadIntrrupt.isInterrupted());
        System.out.println(Thread.currentThread());
    }
}
