package java8;
//实现的接口中如果用重名默认方法，必须要重写
public class InterfaceImpl1 implements Interface1, Interface2 {

	@Override
	public void method() {
		System.out.println("1一般方法");

	}

	@Override
	public void defaultMethod() {
		// TODO Auto-generated method stub
		Interface1.super.defaultMethod();
	}

}
