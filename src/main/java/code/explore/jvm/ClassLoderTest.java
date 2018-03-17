package code.explore.jvm;

import java.io.InputStream;


public class ClassLoderTest {
	/**
	 * 目的：不同的类使用哪种类加载器
	 * @throws ClassNotFoundException
	 */
	public void testClassLoder() throws ClassNotFoundException {
		//JDK自带的类使用核心类加载器
		ClassLoader classLoader1 = String.class.getClassLoader();
		System.out.println(classLoader1);
		//用户自定义的类使用
		ClassLoader classLoader2 = ClassLoderTest.class.getClassLoader();
		System.out.println(classLoader2);
		//扩展类加载器加载jar/lib/ext下面的类
		ClassLoader parent = classLoader2.getParent();
		System.out.println(parent);
		//jvm.TT这个类打成了jar包放在ext目录下
		ClassLoader classLoader = Class.forName("jvm.TT").getClassLoader();
		System.out.println(classLoader);
	}
	public void test1() {
		InputStream inputStream = getClass().getResourceAsStream("ClassLoderTest.class");
		System.out.println(inputStream);
	}
}
