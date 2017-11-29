package java8;

public class InterfaceTest {
	//成员变量、静态方法 编译和运行都是看左边  非静态方法变异看左,运行看右
	public static void main(String[] args) {
		Interface1.staticMethod();
		
		Interface2 imp1 = new InterfaceImpl1();
		imp1.defaultMethod();
	}
}
