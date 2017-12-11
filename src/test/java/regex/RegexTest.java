package regex;

import org.junit.Test;

public class RegexTest {
	@Test
	public void test() {
		String s = "http://www.baidu.com\\";
		String r = s.replaceAll("\\+", "%20");
		System.out.println(r);
	}
}
