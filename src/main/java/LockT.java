package main.java;

import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockT extends Thread{
    public LockT(AbcTest abcTest){
        this.abcTest=abcTest;
    }

    AbcTest abcTest;
    public static void main(String[] args) {
        AbcTest abcTest1 = new AbcTest();
        LockT lockT = new LockT(abcTest1);
        LockT lockT1 = new LockT(abcTest1);
        lockT.start();
        lockT1.start();
    }


    @Override
    public void run() {
        abcTest.method1();
    }



}
class AbcTest{
    ReentrantLock reentrantLock = new ReentrantLock();
    public void method1(){
        try {
            boolean isLockAquired = reentrantLock.tryLock(5, TimeUnit.SECONDS);
//            Lock lock = new ReentrantLock();
//            Lock lock = readWriteLock.readLock();
//            lock.lock();
//            reentrantLock.lock();
//         System.out.println(isLockAquired);
            if (isLockAquired) {
                System.out.println("lock aquired....");
                Thread.sleep(2000);
            }else{
                System.out.println("lock not aquired....");
            }
            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }finally{
                reentrantLock.unlock();
            }
    }
}