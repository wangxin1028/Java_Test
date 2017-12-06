package wx.euler.juc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest extends TimerTask{
	public static void main(String[] args) {
		LocalDateTime time = LocalDateTime.now();
		Instant instant = time.atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		
		Timer timer = new Timer("Timer-Test", true);
		timer.schedule(new TimerTest(), date, 1000);
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name+" hello");
	}
}
