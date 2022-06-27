package main.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable {
    String msg ;
    public ThreadPool(String name){
        this.msg=name;
    }
    @Override
    public void run() {
        System.out.println("Thread run...."+msg);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread run finished...."+msg);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++){
            ThreadPool threadPool = new ThreadPool(""+i);
            executorService.execute(threadPool);
        }
        executorService.shutdown();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for(int i=0;i<3;i++){
            executorService1.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("e1 started");
                }
            });
        }
        if(!executorService1.isTerminated()){
            executorService1.shutdown();
        }

        ExecutorService executorService2 = Executors.newCachedThreadPool();
        for(int i=0;i<7;i++){
            executorService2.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("e2 started");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        }
        executorService2.shutdown();


    }
}
