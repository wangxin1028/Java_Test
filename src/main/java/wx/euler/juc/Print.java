package wx.euler.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Print {
    private Lock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();
    private int num = 1;

    public void printA() {
        lock.lock();
        try {
            if (num != 1) {
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
            if (num != 2) {
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
            if (num != 3) {
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
