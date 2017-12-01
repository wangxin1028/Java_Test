package io;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class CharStreamTest {
	@Test
	public void test1() {
		try {
			FileWriter writer = new FileWriter("conf/writer.txt");
			writer.write("abc\ndef");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
