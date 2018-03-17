package code.explore.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        CallableDemo demo = new CallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(demo);
        new Thread(futureTask).start();

        try {
            Integer result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class CallableDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
    	Thread.sleep(1000);
        int sum = 0;
        for(int i = 1 ; i <= 100000000 ; i++){
            sum+=i;
        }
        return sum;
    }
}