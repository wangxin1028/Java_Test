package org.wx.juc;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new RunableTask());
        Future<String> future = service.submit(new CallableTask());

        try {
            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
class RunableTask implements Runnable{

    @Override
    public void run() {
        System.out.println("run");
    }
}
class CallableTask implements Callable<String>{

    @Override
    public String call() throws Exception {
        return "hello";
    }
}