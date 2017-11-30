package org.wx.juc;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(100);
        Instant begin = Instant.now();

        for (int i = 0 ;i < 100 ;i++){
            new Thread(new TaskThread(latch)).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();
        System.out.println(Duration.between(begin,end).toMillis());
    }
}
class TaskThread implements Runnable{
    private CountDownLatch latch;
    public TaskThread(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            int sum = 0;
            for(int i = 1; i< 10000000; i++){
                sum+=i;
            }
            System.out.println(sum);
        }finally {
           latch.countDown();
        }

    }
}