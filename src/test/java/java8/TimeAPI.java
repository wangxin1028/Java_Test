package java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoChronology;
import java.time.chrono.MinguoDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

public class TimeAPI {
	/**
	 * LocalDate LocalTime LocalDateTime
	 */
	@Test
	public void testLocalDate() {
		LocalDate ld = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(ld);

		ld = LocalDate.now();
		System.out.println(ld);

		ld = LocalDate.ofYearDay(2017, 300);
		System.out.println(ld);

		ld = LocalDate.ofEpochDay(365);
		System.out.println(ld);

		ld = LocalDate.of(2017, 12, 12);
		System.out.println(ld);

		LocalTime lt = LocalTime.now();
		System.out.println(lt);

		LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		System.out.println(ldt);
	}

	/**
	 * Instant
	 */
	@Test
	public void testInstant() {
		Instant begin = Instant.now();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant end = Instant.now();
		Duration between = Duration.between(begin, end);
		System.out.println(between.getNano());
	}

	/**
	 * 非ISO标准格式的日期
	 */
	@Test
	public void testChronology() {
		MinguoChronology taiwan = MinguoChronology.INSTANCE;
		MinguoDate dateNow = taiwan.dateNow();
		System.out.println(dateNow);

		JapaneseChronology japan = JapaneseChronology.INSTANCE;
		JapaneseDate dateNow2 = japan.dateNow();
		System.out.println(dateNow2);
	}

	/**
	 * 旧的API和新的之间的转换
	 */
	@Test
	public void testOldToNew() {
		// 旧的api
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		System.out.println(zoneId);

		TimeZone timeZone = TimeZone.getTimeZone(zoneId);
		System.out.println(timeZone);

		Calendar instance = Calendar.getInstance();
		System.out.println(instance);

		Date date = Date.from(Instant.now());
		System.out.println(date);
	}
	/**
	 * 格式化
	 */
	@Test
	public void testFormatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		LocalDateTime time = LocalDateTime.now();
		String format = formatter.format(time);
		System.out.println(format);
	}
}
