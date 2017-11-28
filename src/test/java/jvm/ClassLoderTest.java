package jvm;

import org.junit.Test;

import wx.euler.entity.Persion;

public class ClassLoderTest {
	@Test
	public void testClassLoder() throws ClassNotFoundException {
		ClassLoader classLoader1 = String.class.getClassLoader();
		System.out.println(classLoader1);

		ClassLoader classLoader2 = Persion.class.getClassLoader();
		System.out.println(classLoader2);
		
		ClassLoader parent = classLoader2.getParent();
		System.out.println(parent);
		
		ClassLoader classLoader = Class.forName("com.fxp.a.A").getClassLoader();
		System.out.println(classLoader);
		
	}
}
