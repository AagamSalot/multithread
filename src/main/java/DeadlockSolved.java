package main.java;

public class DeadlockSolved {
   
    public static void main(String ar[]) {  
        DeadlockSolved test = new DeadlockSolved();  
   
        final Resource1 a = test.new Resource1();
        final Resource2 b = test.new Resource2();
   
   // Thread-1  
Runnable b1 = new Runnable() {  
    public void run() {  
        synchronized (b) {
           try {
                Thread.sleep(100);
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }
            synchronized (a) {  
                System.out.println("In block 1");  
            }  
        }  
    }
};  
   
// Thread-2  
Runnable b2 = new Runnable() {  
    public void run() {  
        synchronized (b) {
            synchronized (a) {
                System.out.println("In block 2");  
            }  
        }  
    }  
};  
  
   
        new Thread(b1).start();  
        new Thread(b2).start();  
    }  
   
    // resource1  
    private class Resource1 {
        private int i = 10;  
   
        public int getI() {  
            return i;  
        }  
   
        public void setI(int i) {  
            this.i = i;  
        }  
    }
    private class Resource2 {
        private int i = 20;  
   
        public int getI() {  
            return i;  
        }  
   
        public void setI(int i) {  
            this.i = i;  
        }  
    }  
}  