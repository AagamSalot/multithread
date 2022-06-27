package main.java;

public class ThreadDaemon extends Thread {


    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println("daemon works...");
        }else{
            System.out.println("normal works...");
        }
    }

    public static void main(String[] args) {
        ThreadDaemon td1 = new ThreadDaemon();
        ThreadDaemon td2 = new ThreadDaemon();
        td1.setDaemon(true);
        td1.start();
        td2.start();

    }
}