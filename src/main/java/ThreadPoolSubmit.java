package main.java;

import java.util.concurrent.*;

public class ThreadPoolSubmit implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(5000);
        return "hello";
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadPoolSubmit threadPoolSubmit = new ThreadPoolSubmit();
        Future fu1 = executorService.submit(threadPoolSubmit);
        try {
            System.out.println("future object value="+fu1.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }
}
