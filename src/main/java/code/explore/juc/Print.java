package code.explore.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Print {
    public static void main(String[] args) {
        Print p = new Print();
        new Thread(
                () -> {
                    for (int i = 0 ; i < 10 ; i++){
                        p.printA();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (int i = 0 ; i < 10 ; i++){
                        p.printB();
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (int i = 0 ; i < 10 ; i++){
                        p.printC();
                    }
                }
        ).start();
    }
    
    private Lock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();
    private int num = 1;

    public void printA() {
        lock.lock();
        try {
            while (num != 1) {
                try {
                    a.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            num = 2;
            b.signal();

        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
        	while (num != 2) {
                try {
                    b.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            num = 3;
            c.signal();

        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
        	while (num != 3) {
                try {
                    c.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            System.out.println("---------------");
            num = 1;
            a.signal();

        } finally {
            lock.unlock();
        }
    }
}
