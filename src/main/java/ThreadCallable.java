package main.java;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ThreadCallable implements Callable {
    @Override
    public Object call() throws Exception {
        Random randObj = new Random();
        Integer randNo = randObj.nextInt(10);
        Thread.sleep(randNo * 1000);
        return randNo;
    }

    public static void main(String[] args) {
        FutureTask[] taskArray = new FutureTask[10];
        ThreadCallable threadCallable = new ThreadCallable();
        FutureTask futureTask = new FutureTask(threadCallable);
        Thread th2 = new Thread(futureTask);
        th2.start();
        try {
            System.out.println("Value from="+futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<10;i++){
            taskArray[i]=new FutureTask(threadCallable);
            Thread th = new Thread(taskArray[i]);
            th.start();
        }
        try {
            for(int i=0;i<10;i++) {
                Object o1 = taskArray[i].get();
                System.out.println("value=" + o1);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
