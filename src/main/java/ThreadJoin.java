package main.java;

public class ThreadJoin extends Thread{

    public ThreadJoin(String name){
        super(name);
    }

    public ThreadJoin(){
        super();
    }

    public static void main(String[] args) {
        System.out.println("hello");
        ThreadJoin th1 = new ThreadJoin("T1");
        ThreadJoin th2 = new ThreadJoin();
        th2.setName("T2");
        th1.start();

        try {
            th1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
           th2.start();
    }



    public void run(){
       for(int i=0;i<4;i++){
           try {
               Thread.sleep(500);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println("thread..."+Thread.currentThread().getName());
       }

    }
}
