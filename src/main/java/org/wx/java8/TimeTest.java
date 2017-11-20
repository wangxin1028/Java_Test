package org.wx.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoChronology;
import java.time.chrono.MinguoDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeTest {
	public static void main(String[] args) {
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
		
		MinguoChronology taiwan = MinguoChronology.INSTANCE;
		MinguoDate dateNow = taiwan.dateNow();
		System.out.println(dateNow);
		
		JapaneseChronology japan = JapaneseChronology.INSTANCE;
		JapaneseDate dateNow2 = japan.dateNow();
		System.out.println(dateNow2);
		//旧的api
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		System.out.println(zoneId);
		
		TimeZone timeZone = TimeZone.getTimeZone(zoneId);
		System.out.println(timeZone);
		
		Calendar instance = Calendar.getInstance();
		System.out.println(instance);
		
		Date date = Date.from(Instant.now());
		System.out.println(date);
	}
}
