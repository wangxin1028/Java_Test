package wx.euler.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPool {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);
		scheduledThreadPool.scheduleAtFixedRate(()->{
			System.out.println("————————————————————————————————————————————————————————————————————————————");
		}, 0, 1, TimeUnit.SECONDS);
	}
}
