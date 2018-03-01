package test.java.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new RunableTask());
        Future<String> future = service.submit(new CallableTask());

        try {
        	System.out.println("0------0");
            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //程序结束前，应该把连接池关闭，进程不结束
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
    	Thread.sleep(10000);
        return "hello";
    }
}