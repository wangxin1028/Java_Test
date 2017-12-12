package encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class MD5Test {
	@Test
	public void test1() throws NoSuchAlgorithmException {
		String s = "wangxin";
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] digest = md.digest(s.getBytes());
		for (byte b : digest) {
			System.out.println(b);
		}
	}
}
