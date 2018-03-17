package code.explore.java8;

public interface Interface1 {
	public static void staticMethod() {
		//静态方法不可以调用默认方法和抽象方法
		System.out.println("1静态方法");
	}
	public default void defaultMethod() {
		//默认方法既可以调用静态方法也可以调用抽象方法
		method();
		staticMethod();
		System.out.println("1默认方法");
	}
	public void method();
}
