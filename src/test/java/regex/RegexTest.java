package regex;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class RegexTest {
	@Test
	public void test() throws UnsupportedEncodingException {
		String s = "http://www.baidu.com\\";
		String r = s.replaceAll("\\+", "%20");
		System.out.println(r);
	}
}
