package main.java;

class NewThread extends Thread {
    private static ThreadLocal tlocal = new ThreadLocal() {
        protected Object initialValue() {
            return new Integer(a++);
        }
    };
    private static int a = 5;

    NewThread(String name) {
        super(name);
        start();
    }

    public void run() {
        for (int i = 0; i < 2; i++)
            System.out.println(getName() + " " + tlocal.get());
    }
}
public class ThreadLocalInitialValExp {
    public static void main(String[] args) {
        NewThread t1 = new NewThread("task");
        NewThread t2 = new NewThread("task");
    }
}