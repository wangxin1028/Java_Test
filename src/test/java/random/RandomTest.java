package random;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random r = new Random(50);
		System.out.println(r.nextInt(100));
		System.out.println(r.nextInt(100));
		System.out.println(r.nextInt(100));
		Random r2 = new Random(50);
		System.out.println(r2.nextInt(100));
		System.out.println(r2.nextInt(100));
		System.out.println(r2.nextInt(100));
	}
}
